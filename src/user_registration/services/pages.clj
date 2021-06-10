(ns user-registration.services.pages
  (:require [user-registration.services.country-pages.brpages :as brpages]
            [user-registration.services.country-pages.mxpages :as mxpages]))

(def page-ordering
  [:document
   :name
   :date
   :email])

(defn get-pages
  "Return ordered pages for a specific country"
  [country-code]
  (case country-code
    "mx" (mxpages/listar-paginas page-ordering)
    ;; "co" (copages/listar-paginas page-ordering)
    (brpages/listar-paginas page-ordering)))

(defn first-page
  "Return country selection informations"
  []
  {:br {:welcome "Bem vindo ao App de aquisição"
        :select "Selecione o país"
        :start "Começar"}
   :mx {:welcome "Bienvenido a App Adquisición"
        :select "Seleccionar país"
        :start "Para comenzar"}
   :co {:welcome "Bienvenido a App Adquisición"
        :select "Seleccionar país"
        :start "Para comenzar"}})
