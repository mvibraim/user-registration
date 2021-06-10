(ns user-registration.services.country-pages.mxpages
  (:require [user-registration.models.models :as models])
  (:import (clojure.lang PersistentQueue)))

(def empty-queue PersistentQueue/EMPTY)

(defn build-document-page
  "Generates the document prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Cuál es tu RFC"
                                          "Necesitamos su RFC para validar los datos")
                       (models/new-input "string"
                                         "document"))
        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "document")))

(defn build-name-page
  "Generates the name prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Introduzca su nombre"
                                          "Por favor, ingresa tu nombre completo")
                       (models/new-input "string"
                                         "name"))
        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "name")))

(defn build-email-page
  "Generates the email prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Introduce tu correo electronico"
                                          "Por favor, introduzca una dirección de correo electrónico válida")
                       (models/new-input "string"
                                         "email"))
        bottom (models/new-button "Continuar"
                                  (models/new-action "post"
                                                     "/users"
                                                     ["Procesando los datos"
                                                      "Enviando su pedido"
                                                      "Concluido"]))]
    (models/new-page children bottom "email")))

(defn build-birth-date-page
  "Generates the birth date prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Necesitamos tu fecha de nacimiento"
                                          "Informar el día/mes/año")
                       (models/new-input "datetime"
                                         "birthday"
                                         "00/00/0000"))
        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "birth-date")))

(defn build-approved-registration-page
  "Generates the approved registration prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Uhu! Todo bien con su registro."
                                          "Finalmente tienes el control de tu dinero!")
                       (models/new-image "chilling"))
        bottom (models/new-button "Entendido" (models/new-go-to-home))]
    (models/new-page children bottom "approved-registration")))

(defn build-denied-registration-page
  "Generates the denied registration prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Ops! No pudimos completar su registro."
                                          "Comprueba tus datos y vuelve a intentarlo más tarde....")
                       (models/new-image "pf.ludic.others.person"))
        bottom (models/new-button "Entendido" (models/new-go-to-home))]
    (models/new-page children bottom "denied-registration")))

(def page-builders
  {:document   build-document-page
   :name       build-name-page
   :birth-date build-birth-date-page
   :email      build-email-page})

(defn list-ordered-pages
  "List pages ordered by page-ordering"
  [page-ordering]
  (let [ordered-pages (map #((% page-builders)) page-ordering)]
    {:pages ordered-pages :country-code "mx"}))

(defn get-registration-result-page
  "Returns a page according to the registration result"
  [was-approved]
  (if was-approved
    {:pages (conj empty-queue (build-approved-registration-page))}
    {:pages (conj empty-queue (build-denied-registration-page))}))

