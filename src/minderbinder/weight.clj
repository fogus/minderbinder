(ns minderbinder.weight
  (:require [minderbinder.core :refer (defunits-of)]))

(defunits-of weight :kilogram
  "WiP"
  :kg :kilogram
  :g 1/1000
  :gram #{:grams :g}
  
  :hg [100 :grams]
  :hg :hectogram
)