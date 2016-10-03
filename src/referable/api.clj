(ns referable.api
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [ring.util.response :refer [response]]
            [referable.build :as build]))

(defroutes routes
  (GET "/" [] (response (build/properties)))
  (not-found "Not Found"))

(def api
  (-> (handler/api routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
