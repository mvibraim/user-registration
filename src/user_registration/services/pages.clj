(ns user-registration.services.pages
  (:require [user-registration.services.country-pages.brpages :as brpages]
            [user-registration.services.country-pages.mxpages :as mxpages]
            [user-registration.services.country-pages.copages :as copages]))

(defn get-pages
  "select pages for a specific country"
  [country-code]
  (println country-code)
  (case country-code
    "mx" (mxpages/listar-paginas)
    "co" (copages/listar-paginas)
    "br" (brpages/listar-paginas)))

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