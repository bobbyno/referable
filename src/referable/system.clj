(ns referable.system
  (:require
   [com.stuartsierra.component :as component]
   [environ.core :refer [env]]
   [ring.component.jetty :refer [jetty-server]]
   [referable.api :refer [api]])
  (:gen-class))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;  Server initialization
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn make-system [port]
  (component/system-map
   :server (jetty-server {:app {:handler api},
                          :port port})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;  Server state
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def system nil)

(defn init [port]
  (alter-var-root #'system
    (constantly (make-system port))))

(defn start []
  (alter-var-root #'system
    (fn [s] (component/start s))))

(defn stop []
  (alter-var-root #'system
    (fn [s] (when s (component/stop s)))))

(defn go [port]
  (init port)
  (start))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;   Main
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn -main
  "The entry-point for 'lein run'"
  [& [port]]
  (let [port (Integer. (or port (env :port) 8080))]
    (go port)
    (println "Server started...")))
