(ns minderbinder.temperature
  (use [minderbinder.core :only [defunits-of]]))

;(def parse-length-unit identity)
(defunits-of temperature :kelvin
  "TODO"
  :celcius {:scale 1 :offset 273.15}
  :fahrenheit {:scale 5/9 :offset 255.37})

(comment
  (parse-temperature-unit [100 :celcius])
  )