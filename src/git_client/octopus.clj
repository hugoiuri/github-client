(ns git-client.octopus
  (:require [clj-http.client :as client]))

(defn get-octopus
  []
  (get (client/get "https://api.github.com/octocat") :body))