(ns user-registration.database
  (:require [com.stuartsierra.component :as component]))

(defrecord ^:private Database []
  component/Lifecycle

  (start [this]
    (println "Start database")
    (assoc this :store (atom {})))

  (stop [this]
    (println "Stop database")
    (assoc this :store nil)))

(defn new-database []
  (->Database))