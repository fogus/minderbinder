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
            :default) spec)))

(defmacro defunits-of [quantity base-unit & units]
  (let [magnitude (gensym)
        unit (gensym)
        conversions (into `{~base-unit 1} (map vec (partition 2 units)))]
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
  :nybble :nibble
  :nyble :nibble
  :octet :byte
  :kilobyte 1024
  :kibibyte :kilobyte
  :KiB :kibibyte
  :kB :KiB
  :megabyte [1024 :kilobyte]
  :mebibyte :megabyte
  :MiB :mebibyte
  :MB :MiB
  :gigabyte [1024 :megabyte]
  :gibibyte :gigabyte
  :GiB :gibibyte
  :GB :GiB
  :terabyte [1024 :gigabyte]
  :tebibyte :terabyte
  :TiB :tebibyte
  :TB :TiB
  :petabyte [1024 :terabyte]
  :pebibyte :petabyte
  :PiB :pebibyte
  :PB :PiB
  :exabyte [1024 :petabyte]
  :exbibyte :exabyte
  :EiB :exbibyte
  :EB :EiB
  :internet [500N :exabyte]       ;; estimate, as of 2009
  :zettabyte [1024N :exabyte]
  :zebibyte :zettabyte
  :ZiB :zebibyte
  :ZB :ZiB
  :yottabyte [1024N :zettabyte]
  :yobibyte :yottabyte
  :YiB :yobibyte
  :YB :YiB

  :kbit 1000
  :kilobit :kbit
  :kibit :kbit
  :kibibit :kibit
  :Mbit [1000 :kbit]
  :megabit :Mbit
  :Mibit :Mbit
  :mebibit :Mibit
  :Gbit [1000 :Mbit]
;;  :Gbit #{:gigabit :gibibit :Gibit} aliases?
  )

(comment
  (float (unit-of-distance 1 :cable))
  (float 10000000/4999999)
  (unit-of-digital-size 1 :octet)
  (unit-of-digital-size 1 :nybble)
  (unit-of-digital-size 1 :YiB)
)
