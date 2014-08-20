Minderbinder
============

Converting one thing into another via Clojure.

*this is a work in progress and subject to change without a moment's notice*

Use
====

Include the following in your [Leiningen]() project.clj file:

    [fogus/minderbinder "0.2.0"]

Or include the following in your pom.xml file in the `dependencies` section:

```xml
	<dependency>
      <groupId>fogus</groupId>
      <artifactId>minderbinder</artifactId>
      <version>0.2.0</version>
	</dependency>
```

Examples
========

Minderbinder includes unit conversions for the following units of measure:

  * [Time][t]: via `#unit/time`, base is `:milliseconds`, ns is `minderbinder.time`
  * [Length][l]: via `#unit/length`, base is `:meters`, ns is `minderbinder.length`
  * [Information][i]: via `#unit/info`, base is `:byte`, ns is `minderbinder.information`

[t]: https://github.com/fogus/minderbinder/blob/master/src/minderbinder/time.clj
[l]: https://github.com/fogus/minderbinder/blob/master/src/minderbinder/length.clj
[i]: https://github.com/fogus/minderbinder/blob/master/src/minderbinder/information.clj

Using Minderbinder's unit reader form
--------------------------------------

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

Using Minderbinder's unit parse functions
-----------------------------------------

```clojure
    (ns minderbinder.test.core
	  (:require [minderbinder.length :as mbr]))
    
    (mbr/parse-length-unit [1 :km])
    
    ;;=> 1000

    (mbr/parse-length-unit [1 :ramsden-link])
    
    ;;=> 381/1250
```

Defining custom conversion rules
--------------------------------

Defining a unit conversion is accomplished via Minderbinder's `defunits-of` macro.  The body of the macro expects the following structure:

**(defunits-of *unit-name* *base-unit-tag* *docstring* *conversion-spec*)**

The *conversion spec* part of the body currently allows pairs of mappings defined in reletive terms.  The pairs always start with a keyword used as the unit tag.  However, the right-hand side of the pair can be one of the following:

 1. Number  - defines the value of the unit relative to the base unit
 2. Vector  - defines the value of the unit relative to another contained unit
 3. Keyword - defines a single alias for a unit
 4. Set     - defined one or more aliases for a unit
 
A simplified version of [Minderbinder's length conversion definition][l] serves as an example:

```clojure
	(defunits-of length :meter
	  "The meter is the length of the path traveled by light in vacuum during a 
	   time interval of 1/299,792,458 of a second."
	   
	  :m  :meter                   ;; an alias for the base unit
	  :km 1000                     ;; a larger value relative to the base unit
	  :km #{kilometer kilometers}  ;; multiple aliases for a unit
	  :cm 1/100                    ;; a smaller value relative to the base
	  :mm [1/10 :cm])              ;; a value relative to another unit
```

### Generated vars

The `defunits-of` macro will define three things in the namespace where the `defunits-of` macro appears:

 1. `parse-XXX-unit` - a function that parses the unit vector according to the conversion spec, returning the total value relative to the base.

 2. `unit-of-XXX`    - a macro that allows the for `(unit-of-XXX 1 :foo)` that returns the total value relative to the base.
 
 3. `XXX-table`      - a map describing the unit conversion rules.


Plans
=====

* Auto-pluralization
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
* [GNU Units](http://www.gnu.org/software/units/)

License
=======

Distributed under the Eclipse Public License, the same as Clojure.
