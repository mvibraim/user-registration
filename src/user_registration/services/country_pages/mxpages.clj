(ns user-registration.services.country-pages.mxpages
  (:require [user-registration.models.models :as models]))

(defn build-document-page
  "Generates the document prompt page"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (models/new-header "Informe seu CPF"
                                          "precisamos do seu CPF para validar os dados")
                       (models/new-input "string"
                                         "cpf"))



        bottom (models/new-button "Continuar")]
    (models/new-page children bottom)))

(defn build-name-page
  "Generates the name prompt page"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (models/new-header "Informe seu nome"
                                          "por favor insira seu nome completo")
                       (models/new-input "string"
                                         "name"))

        bottom (models/new-button "Continuar")]
    (models/new-page children bottom)))

(defn build-email-page
  "Generates the email prompt page"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (models/new-header "Informe seu email"
                                          "por favor informe um email valido")
                       (models/new-input "string"
                                         "mail"))

        bottom (models/new-button "Continuar" (models/new-action "post" "/users" ["Procesando los datos" "Enviando su pedido" "Concluido"]))]
    (models/new-page children bottom)))

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
    (models/new-page children bottom)))

(def page-builders
  {:document build-document-page
   :name build-name-page
   :date build-birth-date-page
   :email build-email-page})

(defn list-ordered-pages
  "List pages ordered by page-ordering"
  [page-ordering]
  (let [ordered-pages (map #((% page-builders)) page-ordering)]
    {:pages ordered-pages :country-code "mx"}))
