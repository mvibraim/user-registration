(ns user-registration.services.country-pages.copages
  (:require [user-registration.models.models :as models]))

(defn build-document-page
  "Generates the document prompt page"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (models/new-header "Cuál es tu Cual es tu Número de Identificación Nacional"
                                          "necesitamos su Número de Identificación Nacional")
                       (models/new-input "string"
                                         "nni"))



        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "document")))

(defn build-name-page
  "Generates the name prompt page"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (models/new-header "Introduzca su nombre"
                                          "por favor ingresa tu nombre completo")
                       (models/new-input "string"
                                         "name"))

        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "name")))

(defn build-email-page
  "Generates the email prompt page"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (models/new-header "Introduce tu correo electronico"
                                          "Por favor introduzca una dirección de correo electrónico válida")
                       (models/new-input "string"
                                         "mail"))

        bottom (models/new-button "Continuar" (models/new-action "post" "/users" ["Procesando los datos" "Enviando su pedido" "Concluido"]))]
    (models/new-page children bottom "email")))

(defn build-birth-date-page
  "Generates the birth date prompt page"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (models/new-header "Necesito tu fecha de nacimiento"
                                          "informar el día / mes / año")
                       (models/new-input "datetime"
                                         "birthday"
                                         "00/00/0000"))
        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "birth-date")))

(def page-builders
  {:document build-document-page
   :name build-name-page
   :birth-date build-birth-date-page
   :email build-email-page})

(defn list-ordered-pages
  "List pages ordered by page-ordering"
  [page-ordering]
  (let [ordered-pages (map #((% page-builders)) page-ordering)]
    {:pages ordered-pages :country-code "co"}))
