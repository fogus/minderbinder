(ns minderbinder.distance
  (use [minderbinder.core :only [defunits-of]]))

(defunits-of distance ::m
  ::km 1000
  ::cm 1/100
  ::mm [1/10 ::cm]
  ::nm [1/1000 ::mm]

  ::yard 9144/10000
  ::foot [1/3 ::yard]
  ::inch [1/12 ::foot]
  ::mile [1760 ::yard]
  ::furlong [1/8 ::mile]

  ::fathom [10000000/4999999 ::yard]
  ::nautical-mile 1852
  ::cable [216000/1822831 ::nautical-mile]

  ::old-brit-nautical-mile [6080/3 ::yard]
  ::old-brit-cable [1/10 ::old-brit-nautical-mile]
  ::old-brit-fathom [1/100 ::old-brit-cable])

(unit-of-distance 1 ::yard)