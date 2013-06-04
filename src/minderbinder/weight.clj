(ns minderbinder.weight
  (:require [minderbinder.core :refer (defunits-of)]))

(defunits-of weight :kilogram
  "WiP"
  :kg #{:kilograms :kilogram}
  :g 1/1000
  :gram #{:grams :g}
  
  :hg [100 :grams]
  :hg #{:hectograms :hectogram}

  :dg [1/10 :g]
  :dg #{:decigrams :decigram}
  
  :dag [10 :g]
  :dag #{:decagrams :decagram}
  
  :cg [1/10 :dg]
  :mg [1/10 :cg]
  :Mg 1000
  :Mg #{:tonne :metric-ton}
  :Gg [1000 :Mg]
  :Tg [1000 :Gg]
  :Pg [1000 :Tg]
  :Eg [1000 :Pg]
  :Zg [1000 :Eg]
  :Yg [1000 :Zg]
  :mcg [1/1000 :g]
  :ng [1/1000 :mcg]
  :pg [1/1000 :ng]
  :fg [1/1000 :pg]
  :ag [1/1000 :fg]
  :zg [1/1000 :ag]
  :yg [1/1000 :yg])