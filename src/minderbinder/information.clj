(ns minderbinder.information
  (use [minderbinder.core :only [defunits-of]]))

(defunits-of information ::byte
  "TODO"
  ::bit 1/8
  ::nibble 1/2
  ::nibble #{::nybble ::nyble}
  ::octet ::byte
  ::kilobyte 1024
  ::kilobyte #{::kibibyte ::KiB ::kB}
  ::megabyte [1024 ::kilobyte]
  ::megabyte #{::mebibyte ::MiB ::MB}
  ::gigabyte [1024 ::megabyte]
  ::gigabyte #{::gibibyte ::GiB ::GB}
  ::terabyte [1024 ::gigabyte]
  ::terabyte #{::tebibyte ::TiB ::TB}
  ::petabyte [1024 ::terabyte]
  ::petabyte #{::pebibyte ::PiB ::PB}
  ::exabyte [1024 ::petabyte]
  ::exabyte #{::exbibyte ::EiB ::EB}
  ::internet [500N ::exabyte]        ;; estimate, as of 2009
  ::zettabyte [1024N ::exabyte]
  ::zettabyte #{::zebibyte ::ZiB ::ZB}
  ::yottabyte [1024N ::zettabyte]
  ::yottabyte #{::yobibyte ::YiB ::YB}

  ::kbit [1000 ::bit]
  ::kbit #{::kilobit ::kibit ::kibibit}
  ::Mbit [1000 ::kbit]
  ::Mbit #{::megabit ::Mibit ::mebibit}
  ::Gbit [1000 ::Mbit]
  ::Gbit #{::gigabit ::gibibit ::gibit})
