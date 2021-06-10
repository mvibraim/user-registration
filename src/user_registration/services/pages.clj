(ns user-registration.services.pages
  (:require [user-registration.services.country-pages.brpages :as brpages]
            [user-registration.services.country-pages.mxpages :as mxpages]
            [user-registration.services.country-pages.copages :as copages]))

(def page-ordering
  [:document
   :name
   :birth-date
   :email])

(defn get-pages
  "Return ordered pages for a specific country"
  [country-code]
  (case country-code
    "mx" (mxpages/list-ordered-pages page-ordering)
    "co" (copages/list-ordered-pages page-ordering)
    "br" (brpages/list-ordered-pages page-ordering)))

(defn first-page
  "Return country selection informations"
  []
  {
   :countries [
               {:text "Brasil" :value "br"}
               {:text "México" :value "mx"}
               {:text "Colômbia" :value "co"}
              ]
   :br {:welcome "Bem vindo ao App de aquisição"
        :select "Selecione o país"
        :start "Começar"}
   :mx {:welcome "Bienvenido a App Adquisición"
        :select "Seleccionar país"
        :start "Para comenzar"}
   :co {:welcome "Bienvenido a App Adquisición"
        :select "Seleccionar país"
        :start "Para comenzar"}})
