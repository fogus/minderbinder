(ns minderbinder.temperature
  (:require [minderbinder.core :refer (defunits-of)]))

(defunits-of temperature :kelvin
  ""

  ;; 1|273.16 of the thermodynamic temperature of the triple
  ;; point of water
  :kelvin #{:K}

  :celcius    {:scale 1   :offset 273.15}
  :fahrenheit {:scale 5/9 :offset 255.37})
