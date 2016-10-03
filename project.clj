(defproject referable "0.1.0-SNAPSHOT"
  :description "A RESTful API reference implementation"
  :url "https://www.github.com/bobbyno/referable"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.stuartsierra/component "0.3.1"]
                 [compojure "1.5.1"]
                 [environ "1.1.0"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [ring-jetty-component "0.3.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler referable.api/api
         :open-browser? false
         :port 8080}
  :pedantic? :warn
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]
                                  [cheshire "5.6.3"]]}
             :uberjar {:main referable.system
                       :omit-source true
                       :aot :all}})
