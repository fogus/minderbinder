(ns minderbinder.time
  (use [minderbinder.core :only [defunits-of]]))

(defunits-of time ::second
  ""
  ::second    #{::sec ::s}
  ::minute    60
  ::min       ::minute
  ::hr        [60 ::min]
  ::hour      ::hr
  ::day       [24 ::hour]
  ::day       #{::d ::da}
  ::week      [7 ::day]
  ::week      #{::wk ::sennight}
  ::fortnight [14 ::day]
  ::blink     [1/100000 ::day]
  ::ce        [1/100 ::day])
