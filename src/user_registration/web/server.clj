(ns user-registration.web.server
  (:require [com.stuartsierra.component :as component]
            [io.pedestal.http :as http]))

(defrecord ^:private Server [routes]
  component/Lifecycle

  (start [_this]
    (def service-map {::http/routes (:endpoints routes)
                      ::http/port 9000
                      ::http/type :jetty
                      ::http/join? false})

    (defonce server (atom nil))

    (defn start-server []
      (reset! server (http/start (http/create-server service-map))))

    (defn stop-server []
      (http/stop @server))

    (defn restart-server []
      (stop-server)
      (start-server))

    (defn start []
      (try (start-server) (catch Exception e (println "Start error" (.getMessage e))))
      (try (restart-server) (catch Exception e (println "Restart error" (.getMessage e)))))

    (start))

  (stop [this] this))

(defn new-server []
  (map->Server {}))