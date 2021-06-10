(ns user-registration.services.country-pages.brpages
  (:require [user-registration.models.models :as models])
  (:import (clojure.lang PersistentQueue)))

(def empty-queue PersistentQueue/EMPTY)

(defn build-document-page
  "Generates the document prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Informe seu CPF"
                                          "precisamos do seu CPF para validar os dados")
                       (models/new-input "number"
                                         "cpf"
                                         "000.000.000-00"))

        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "document")))

(defn build-name-page
  "Generates the name prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Informe seu nome"
                                          "por favor insira seu nome completo")
                       (models/new-input "string"
                                         "name"))

        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "name")))

(defn build-email-page
  "Generates the email prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Informe seu email"
                                          "por favor informe um email válido")
                       (models/new-input "string"
                                         "mail"))

        bottom (models/new-button "Continuar" (models/new-action "post" "/users" ["Processando os dados" "Enviando seu pedido" "Concluído"]))]
    (models/new-page children bottom "email")))

(defn build-birth-date-page
  "Generates the birth date prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Precisamos da sua data de nascimento"
                                          "informe o dia/mês/ano")
                       (models/new-input "datetime"
                                         "birthday"
                                         "00/00/0000"))
        bottom (models/new-button "Continuar")]
    (models/new-page children bottom "birth-date")))

(defn build-approved-registration-page
  "Generates the approved registration prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Uhu! Tudo certo com o seu cadastro."
                                          "Finalmente você no controle do seu dinheiro!")
                       (models/new-image "chilling"))

        bottom (models/new-button "Entendido")]
    (models/new-page children bottom "approved-registration")))

(defn build-denied-registration-page
  "Generates the denied registration prompt page"
  []
  (let [children (conj empty-queue
                       (models/new-header "Ops! Não conseguimos concluir o seu cadastro."
                                          "Verifique os seus dados e tente novamente mais tarde...")
                       (models/new-image "pf_ludic_others_person"))

        bottom (models/new-button "Entendido")]
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
    {:pages ordered-pages :country-code "br"}))

(defn get-registration-result-page
  "Returns a page according to the registration result"
  [was-approved]
  (if was-approved
    {:pages (conj empty-queue (build-approved-registration-page))}
    {:pages (conj empty-queue (build-denied-registration-page))}))

