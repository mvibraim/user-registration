(ns user-registration.core
  (:require [clojure.pprint :as p]
            [com.stuartsierra.component :as component]
            [user-registration.database :as database]
            [user-registration.routes :as routes]
            [user-registration.server :as server])
  (:gen-class))

(defn component-system []
  (component/system-map
   :database (database/new-database)
   :routes (routes/new-routes)
   :server (component/using (server/new-server) [:database :routes])))

(def component-result (component/start (component-system)))

(def test-request (-> component-result :server :test-request))

(p/pprint component-result)

(test-request :get "/pages")