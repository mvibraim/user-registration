(ns user-registration.routes
  (:require [com.stuartsierra.component :as component]
            [io.pedestal.http.route :as route]))

(defrecord ^:private Routes []
  component/Lifecycle

  (start [this]
    (println "Start routes")

    (defn pages [request]
      {:status 200 :body {:message "aaaa"}})

    (defn users [uuid name status]
      {:id uuid :name name :status status})

    ;; (defn create-todo [request]
    ;;   (let [uuid (java.util.UUID/randomUUID)
    ;;         name (get-in request [:query-params :name])
    ;;         status (get-in request [:query-params :status])
    ;;         todo (create-todo-map uuid name status)
    ;;         store (:store request)]
    ;;     (swap! store assoc uuid todo)
    ;;     {:status 200 :body {:message "done" :todo todo}}))

    ;; (defn hello-function [request]
    ;;   {:status 200 :body (str "Welcome" (get-in request [:query-params :name] "everybody"))})

    (def routes (route/expand-routes
                 #{["/pages" :get pages :route-name :pages]
                   ["/users" :post users :route-name :users]}))

    (assoc this :endpoints routes))

  (stop [this]
    (println "Stop routes")
    (assoc this :endpoints nil)))

(defn new-routes []
  (->Routes))


