(ns minderbinder.length
  (use [minderbinder.core :only [defunits-of]]))

(def parse-length-unit identity)

(defunits-of length :meter
  "The meter is the length of the path travelled by light in vacuum during a 
   time interval of 1/299,792,458 of a second."
  :m  :meter
  :km 1000
  :cm 1/100
  :mm [1/10 :cm]
  :nm [1/1000 :mm]

  :yard 9144/10000
  :foot [1/3 :yard]
  :foot #{:feet :ft}
  :inch [1/12 :foot]
  :mile [1760 :yard]
  :furlong [1/8 :mile]

  :fathom [10000000/4999999 :yard]
  :survey-ft [1/6 :fathom]
  :nautical-mile 1852
  :cable [216000/1822831 :nautical-mile]
  :cable-length :cable
  :metric-cable 200
  :navy-cable-length [720 :survey-ft]
  :marine-league [3 :nautical-mile]
  :old-us-nautical-mile 30401/5

  :data-mile [6000 :ft]

  :shackle [15 :fathom]
  :shackle-of-cable [25/2 :fathom]
  :shackle-uk-royal-navy :shackle-of-cable
  :old-brit-nautical-mile [6080/3 :yard]
  :old-brit-cable [1/10 :old-brit-nautical-mile]
  :old-brit-fathom [1/100 :old-brit-cable]

  :surveyors-chain [66 :survey-ft]
  :surveyors-pole [1/4 :surveyors-chain]
  :surveyors-link [1/100 :surveyors-chain]
  :chain :surveyors-chain
  :chain #{:survey-chain :ch}
  :link :surveyors-link
  :gunters-chain :surveyors-chain
  :engineers-chain [100 :ft]
  :engineers-link [1/100 :engineers-chain]
  :ramsden-chain :engineers-chain
  :ramsden-link :engineers-link
  :au 149597870700
  :light-year 9460730472580800
  :light-second 299792458)


(comment
  (int
   (/ (unit-of-length 1 :fathom)
      (unit-of-length 1 :survey-ft)))

  (double (unit-of-length 1 :surveyors-pole))

  (parse-length-unit [1 :km])
  (parse-length-unit [1 :ramsden-link])
)