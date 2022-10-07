(ns git-client.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [git-client.octopus :refer :all]))

(defroutes app-routes
  (GET "/" [] 
    (response (get-octopus)))
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-params)
      (json/wrap-json-response)))
