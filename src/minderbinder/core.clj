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

(defmacro defunits-of [quantity base-unit & units]
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

(defunits-of distance :m
  :km 1000
  :cm 1/100
  :mm [1/10 :cm]
  :nm [1/1000 :mm]

  :yard 9144/10000
  :foot [1/3 :yard]
  :inch [1/12 :foot]
  :mile [1760 :yard]
  :furlong [1/8 :mile]

  :fathom [10000000/4999999 :yard]
  :nautical-mile 1852
  :cable [216000/1822831 :nautical-mile]

  :old-brit-nautical-mile [6080/3 :yard]
  :old-brit-cable [1/10 :old-brit-nautical-mile]
  :old-brit-fathom [1/100 :old-brit-cable])

(defunits-of digital-size :byte
  :bit 1/8
  :nibble 1/2
  :nibble #{:nybble :nyble}
  :octet :byte
  :kilobyte 1024
  :kilobyte #{:kibibyte :KiB :kB}
  :megabyte [1024 :kilobyte]
  :megabyte #{:mebibyte :MiB :MB}
  :gigabyte [1024 :megabyte]
  :gigabyte #{:gibibyte :GiB :GB}
  :terabyte [1024 :gigabyte]
  :terabyte #{:tebibyte :TiB :TB}
  :petabyte [1024 :terabyte]
  :petabyte #{:pebibyte :PiB :PB}
  :exabyte [1024 :petabyte]
  :exabyte #{:exbibyte :EiB :EB}
  :internet [500N :exabyte]       ;; estimate, as of 2009
  :zettabyte [1024N :exabyte]
  :zettabyte #{:zebibyte :ZiB :ZB}
  :yottabyte [1024N :zettabyte]
  :yottabyte #{:yobibyte :YiB :YB}

  :kbit [1000 :bit]
  :kbit #{:kilobit :kibit :kibibit}
  :Mbit [1000 :kbit]
  :Mbit #{:megabit :Mibit :mebibit}
  :Gbit [1000 :Mbit]
  :Gbit #{:gigabit :gibibit :gibit})

(comment
  (float (unit-of-distance 1 :cable))
  (float 10000000/4999999)
  (unit-of-digital-size 1 :octet)
  (unit-of-digital-size 1 :nybble)
  (unit-of-digital-size 1 :gibit)
)
