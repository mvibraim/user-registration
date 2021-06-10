(ns user-registration.services.pages
  (:require [user-registration.services.country-pages.brpages :as brpages]
            [user-registration.services.country-pages.mxpages :as mxpages]))

(defn get-pages
  "select pages for a specific country"
  [country-code]
  (case country-code
    "mx" (mxpages/listar-paginas)
    ;; "co" {:status 200 :body (json/write-str (copages/listar-paginas))}
    (brpages/listar-paginas)))

(defn first-page []
  {:br {:welcome "Bem vindo ao App de aquisição"
        :select "Selecione o país"
        :start "Começar"}
   :mx {:welcome "Bienvenido a App Adquisición"
        :select "Seleccionar país"
        :start "Para comenzar"}
   :co {:welcome "Bienvenido a App Adquisición"
        :select "Seleccionar país"
        :start "Para comenzar"}})
