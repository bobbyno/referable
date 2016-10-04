(ns {{namespace}}.build
  (:require [environ.core :refer [env]]
            [cheshire.core :as json]))

(defn- jar-name
  "Returns the name of the jar of the running code or nil."
  []
  (-> clojure.lang.RT
      .getProtectionDomain
      .getCodeSource
      .getLocation
      .getPath
      java.io.File.
      .getName))

(defn properties []
  {:version (or (:{{namespace}}-version env) (jar-name))})
