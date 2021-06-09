(ns user-registration.web.interceptors
  (:require [clojure.data.json :as json]
            [io.pedestal.http.content-negotiation :as conneg]))

(def accepted-type "application/json")

(def content-neg-intc (conneg/negotiate-content [accepted-type]))

(defn coerce-to [response content-type]
  (-> response
      (update :body json/write-str)
      (assoc-in [:headers "Content-Type"] content-type)))

(def coerce-response-body
  {:name ::coerce-response-body
   :leave
   (fn [context]
     (cond-> context
       (nil? (get-in context [:response :headers "Content-Type"]))
       (update-in [:response] coerce-to accepted-type)))})