(ns minderbinder.solid-angle
  (:require [minderbinder.core :refer (defunits-of)]))

(defunits-of solid-angle :steradian
  ""

  ;; Solid angle which cuts off an area of the surface
  ;; of the sphere equal to that of a square with
  ;; sides of length equal to the radius of the sphere.
  :steradian #{:sr})