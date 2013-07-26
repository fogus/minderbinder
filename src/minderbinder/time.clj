(ns minderbinder.time
  (:require [minderbinder.core :refer (defunits-of)]))

(defunits-of time :millisecond
  ""
  :millisecond #{:ms :milliseconds}
  :second      1000
  :second      #{:sec :s :seconds}
  :minute      [60 :sec]
  :minute      #{:min :minutes :m}
  :hour        [60 :min]
  :hour        #{:hours :hr}
  :day         [24 :hour]
  :day         #{:d :da :days}
  :week        [7 :day]
  :week        #{:wk :sennight :weeks}
  :fortnight   [14 :day]
  :blink       [1/100000 :day]
  :ns          [1000000000 :seconds]
  :shake       [10 :ns]
  :jiffy       [1/100 :second]
  :moment      [90 :seconds]
  :dog-year    [52 :days]
  :ce          [1/100 :day])

