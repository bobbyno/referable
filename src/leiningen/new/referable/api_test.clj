(ns {{namespace}}.api-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [{{namespace}}.api :refer :all]
            [cheshire.core :as json]))

(deftest root-returns-valid-json-with-version
  (let [response (api (mock/request :get "/"))
        ;; nb: this approach for version works with lein test or repl, but not from a jar.
        version (-> "project.clj" slurp read-string (nth 2))]
    (is (= (get-in response [:headers "Content-Type"])
           "application/json; charset=utf-8"))
    (is (= 200 (:status response)))
    (is (= version (:version (json/parse-string (:body response) true))))))

(deftest not-found
  (let [response (api (mock/request :get "/invalid"))]
    (is (= 404 (:status response)))))
