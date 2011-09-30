(ns minderbinder.length
  (use [minderbinder.core :only [defunits-of]]))

(defunits-of length ::meter
  ::m  ::meter
  ::km 1000
  ::cm 1/100
  ::mm [1/10 ::cm]
  ::nm [1/1000 ::mm]

  ::yard 9144/10000
  ::foot [1/3 ::yard]
  ::foot #{::feet ::ft}
  ::inch [1/12 ::foot]
  ::mile [1760 ::yard]
  ::furlong [1/8 ::mile]

  ::fathom [10000000/4999999 ::yard]
  ::survey-ft [1/6 ::fathom]
  ::nautical-mile 1852
  ::cable [216000/1822831 ::nautical-mile]
  ::cable-length ::cable
  ::metric-cable 200
  ::navy-cable-length [720 ::survey-ft]
  ::marine-league [3 ::nautical-mile]
  ::old-us-nautical-mile 30401/5

  ::data-mile [6000 ::ft]

  ::shackle [15 ::fathom]
  ::shackle-of-cable [25/2 ::fathom]
  ::shackle-uk-royal-navy ::shackle-of-cable
  ::old-brit-nautical-mile [6080/3 ::yard]
  ::old-brit-cable [1/10 ::old-brit-nautical-mile]
  ::old-brit-fathom [1/100 ::old-brit-cable]

  ::surveyors-chain [66 ::survey-ft]
  ::surveyors-pole [1/4 ::surveyors-chain]
  ::surveyors-link [1/100 ::surveyors-chain]
  ::chain ::surveyors-chain
  ::chain #{::survey-chain ::ch}
  ::link ::surveyors-link
  ::gunters-chain ::surveyors-chain
  ::engineers-chain [100 ::ft]
  ::engineers-link [1/100 ::engineers-chain]
  ::ramsden-chain ::engineers-chain
  ::ramsden-link ::engineers-link)

(comment
  (int
   (/ (unit-of-distance 1 ::fathom)
      (unit-of-distance 1 ::survey-ft)))

  (double (unit-of-distance 1 ::surveyors-pole))
)