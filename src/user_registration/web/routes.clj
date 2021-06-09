(ns user-registration.web.routes
  (:require [com.stuartsierra.component :as component]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route :as route]
            [user-registration.web.controllers :as controllers]
            [user-registration.web.interceptors :as interceptors]))

(defrecord ^:private Routes []
  component/Lifecycle

  (start [this]
    (println "Start routes")

    (def routes (route/expand-routes
                 #{["/pages" :get [interceptors/coerce-response-body
                                   interceptors/content-neg-intc
                                   controllers/pages] :route-name :pages]
                   ["/users" :post [interceptors/coerce-response-body
                                    interceptors/content-neg-intc
                                    (body-params/body-params)
                                    controllers/users] :route-name :users]
                   ["/main" :get [interceptors/coerce-response-body
                                  interceptors/content-neg-intc
                                  controllers/first-page] :route-name :first-page]}))

    (assoc this :endpoints routes))

  (stop [this]
    (println "Stop routes")
    (assoc this :endpoints nil)))

(defn new-routes []
  (->Routes))
