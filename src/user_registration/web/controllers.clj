(ns user-registration.web.controllers
  (:require [user-registration.services.pages :as pages]
            [user-registration.services.users :as users]))

(defn ok [body]
  {:status 200 :body body})

(defn pages [request]
  (let [country-code (get-in request [:query-params :country-code])
        response (pages/get-pages country-code)]
    (ok response)))

(defn users [request]
  (let [body (:json-params request)]
    (users/validation body)))

(defn first-page [_request]
  (let [response (pages/first-page)]
    (ok response)))
