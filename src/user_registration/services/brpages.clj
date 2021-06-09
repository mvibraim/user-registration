(ns user-registration.services.brpages
  (:require [user-registration.models.models :as model]))

(defn montar-main-br
  "devolve a pagina inicial em Pt-br"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Boas-vindas ao Nubank!"
                                          "Um mundo financeiro sem complexidades")
                       (model/novo-select [(model/novo-combo-item "Brasil" "br")
                                           (model/novo-combo-item "Mexico" "mx")
                                           (model/novo-combo-item "Colombia" "cl")])
                       )
        bottom (conj clojure.lang.PersistentQueue/EMPTY (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-cpf
  "deviolve a pagina do CPF em PT-br"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu CPF"
                                          "precisamos do seu CPF para validar os dados")
                       (model/novo-input "string"
                                         "cpf"))
        
        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-nome-br
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu nome"
                                          "por favor insira seu nome completo")
                       (model/novo-input "string"
                                         "name"))

        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-email-br
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu email"
                                          "por favor informe um email valido")
                       (model/novo-input "string"
                                         "mail"))

        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar" (model/nova-action "post" "/register")))]
    (model/nova-pagina children bottom)))

(defn listar-paginas
  "Listar em ordem as paginas da aplicação"
  []
  (let [paginas (conj clojure.lang.PersistentQueue/EMPTY (montar-main-br) (montar-cpf) (montar-nome-br) (montar-email-br))]
    {:paginas paginas}))

(defn registration-sucess
  "define a registration with sucess"
  [])

(defn registration-fail
  "define a registration with deny"  [])