(ns minderbinder.core)

(defn- relative-units [u units history]
  (if (some #{u} history)
    (throw (Exception. (str "Cycle in " u " and " history))))
  (let [spec (u units)]
    (if (nil? spec)
      (throw (Exception. (str "Undefined unit " u)))
      (cond (vector? spec) (let [[conv to] spec]
                             (try
                               (* conv
                                  (relative-units to units [u history]))
                               (catch ArithmeticException e
                                 (throw (ArithmeticException. (str (.getCause e)
                                                                   " in " spec))))))
            (keyword? spec) (relative-units spec units [u history])
            :default spec))))

(defn- build-conversion-map
  [base-unit unit-pairs]
  (into `{~base-unit 1}
        (reduce concat
                (for [[k v] (partition 2 unit-pairs)]
                  (if (set? v)
                    (map vec (partition 2 (interleave v (repeat k))))
                    [[k v]])))))

(defmacro defunits-of [quantity base-unit desc & units]
  (let [magnitude (gensym)
        unit (gensym)
        conversions (build-conversion-map base-unit units)]
    `(do
       (defmacro ~(symbol (str "unit-of-" quantity)) [~magnitude ~unit]
         `(* ~~magnitude
             ~(case ~unit
                    ~@(mapcat
                       (fn [[u# & r#]]
                         `[~u# ~(relative-units u# conversions [])])
                       conversions)))))))
