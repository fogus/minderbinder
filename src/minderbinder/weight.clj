(ns minderbinder.weight
  (:require [minderbinder.core :refer (defunits-of)]))

(defunits-of weight :kilogram
  "WiP"
  :kg :kilogram
  :g 1/1000
  :gram #{:grams :g}
  
  :hg [100 :grams]
  :hg :hectogram

  :dg [1/10 :g]
  :dg :decigram)