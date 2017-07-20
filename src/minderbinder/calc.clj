(ns minderbinder.calc
  (:require [minderbinder.core :as core]
            [minderbinder.time :as time]))

[16'ft 10'in]

time/time-table

(def T {:julian-day :day, :min :minute, :day [24 :hour], :hour [60 :min], 
        :week [7 :day], :hr :hour, :blink [1/100000 :day], :shake [10 :ns], 
        :ce [1/100 :day], :second 1000, :fortnight [14 :day], 
        :ns [1000000000 :seconds], :m :minute, :dog-year [52 :days], 
        :days :day, :seconds :second, :leap-year [366 :days], :s :second, 
        :julian-days :day, :julian-year :year, :decade [10 :years], 
        :year [365.25 :days], :sennight :week, :millisecond 1, 
        :century [100 :years], :sec :second, :hours :hour, :jiffy [1/100 :second], 
        :years :year, :d :day, :milliseconds :millisecond, :da :day, 
        :mastery [10000 :hours], :minutes :minute, :wk :week, 
        :julian-years :year, :ms :millisecond, :weeks :week, :moment [90 :seconds], 
        :minute [60 :sec]})

;;time/unit-of-time

(defn scale [conversion-table descriptor]
  (let [[mag unit] descriptor
        conv (get conversion-table unit)]
    (cond (keyword? conv) (scale conversion-table [mag conv])      ;; Single alias
          (vector?  conv) (* mag (scale conversion-table conv))    ;; Relative unit
          (map? conv)     (+ (* mag (:scale conv)) (:offset conv))  ;; Scale and offset
          :default (* mag conv))))

(scale T [1 :seconds])

(defn convert
  [conversion-table descriptor]
  (reduce +
          (map #(scale conversion-table %)                               
               (partition 2 descriptor))))

(time/parse-time-unit [6 :seconds])

(convert T [1 :min 3 :sec])
