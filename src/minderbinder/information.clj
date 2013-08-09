(ns minderbinder.information
  (:require [minderbinder.core :refer (defunits-of)]))

;; Basic unit of information (entropy).  The entropy in bits
;; of a random variable over a finite alphabet is defined
;; to be the sum of -p(i)*log2(p(i)) over the alphabet where
;; p(i) is the probability that the random variable takes
;; on the value i.

(defunits-of information :bit
  ""
  :byte 8
  :byte #{:bytes}
  :nibble [1/2 :byte]
  :nibble #{:nybble :nyble}
  :octet :byte
  :kilobyte [1024 :bytes]
  :kilobyte #{:kibibyte :KiB :kB}
  :megabyte [1024 :kilobyte]
  :megabyte #{:mebibyte :MiB :MB}
  :gigabyte [1024 :megabyte]
  :gigabyte #{:gibibyte :GiB :GB}
  :terabyte [1024 :gigabyte]
  :terabyte #{:tebibyte :TiB :TB}
  :petabyte [1024 :terabyte]
  :petabyte #{:pebibyte :PiB :PB}
  :exabyte [1024 :petabyte]
  :exabyte #{:exbibyte :EiB :EB}
  :internet [500N :exabyte]        ;; estimate, as of 2009
  :zettabyte [1024N :exabyte]
  :zettabyte #{:zebibyte :ZiB :ZB}
  :yottabyte [1024N :zettabyte]
  :yottabyte #{:yobibyte :YiB :YB}

  :kbit [1000 :bit]
  :kbit #{:kilobit :kibit :kibibit}
  :Mbit [1000 :kbit]
  :Mbit #{:megabit :Mibit :mebibit}
  :Gbit [1000 :Mbit]
  :Gbit #{:gigabit :gibibit :gibit})
