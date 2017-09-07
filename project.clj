(defproject fogus/minderbinder "0.3.0"
  :description "Converting one thing into another thing via Clojure at read time and compile time."
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :plugins [[marginalia "0.8.0-SNAPSHOT"]]
  :repositories [["snapshots" "https://oss.sonatype.org/content/repositories/snapshots/"]]
  :deploy-repositories [["clojars" {:sign-releases false}]])
