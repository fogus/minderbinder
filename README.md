Minderbinder
============

Converting one thing into another via Clojure.

*this is a work in progress and subject to change without a moment's notice*

Examples
========

Using Minderbinder's base conversions
-------------------------------------

```clojure
    (ns minderbinder.test.core
	  (:require minderbinder.time))
    
    (== #unit/time [1 :second]
        #unit/time [1000 :ms])
    
    ;;=> true

    (== #unit/time [1 :minute 30 :seconds]
        #unit/time [90 :seconds])
    
    ;;=> true
```

Defining custom conversion rules
--------------------------------

TODO

Plans
=====

* ClojureScript integration
* More conversions included by default
* Base unit changing
* Cross-unit conversions via function results
* More plans not yet thought up.

References
==========

* [NIST Weights and Measures](http://www.nist.gov/pml/wmd/)
* [Let Over Lambda](http://www.amazon.com/dp/1435712757/?tag=fogus-20)
* [Frink](http://futureboy.us/frinkdocs/)

License
=======

Distributed under the Eclipse Public License, the same as Clojure.
