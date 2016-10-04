(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.stuartsierra/component "0.3.1"]
                 [compojure "1.5.1"]
                 [environ "1.1.0"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [ring-jetty-component "0.3.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [ch.qos.logback/logback-classic "1.1.7"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler {{namespace}}.api/api
         :open-browser? false
         :port 8080}
  :resource-paths ["resources"]
  :pedantic? :warn
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]
                                  [cheshire "5.6.3"]]}
             :uberjar {:main {{namespace}}.system
                       :omit-source true
                       :aot :all}})
