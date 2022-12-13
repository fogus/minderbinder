(ns build
  (:require [clojure.tools.build.api :as b]))

(def lib 'fogus/minderbinder)
(def version (format "0.0.%s" (b/git-count-revs nil)))
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
  (b/delete {:path "target"}))

(defn prep [_]
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  :class-dir class-dir
                  :ns-compile [fogus.riverdale.ui.applet fogus.riverdale.dice.commandline]}))

(defn jar [_]
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis basis
                :src-dirs ["src"]})
  
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  
  (b/jar {:class-dir class-dir
          :jar-file jar-file}))


