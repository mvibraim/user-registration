(ns user-registration.core
  (:require [com.stuartsierra.component :as component]
            [user-registration.web.routes :as routes]
            [user-registration.web.server :as server])
  (:gen-class))

(defn component-system []
  (component/system-map
   :routes (routes/new-routes)
   :server (component/using (server/new-server) [:routes])))

(component/start (component-system))
