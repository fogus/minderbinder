(ns minderbinder.test.core
  (:use [minderbinder.core] :reload)
  (:require minderbinder.time)
  (:use [clojure.test]))

(deftest test-time-units
  (is (= 1000 (minderbinder.time/parse-time-unit [1 :second])))
  (is (= 1000 #unit/time [1 :second])))
