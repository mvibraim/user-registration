(ns user-registration.services.country-pages.mxpages
  (:require [user-registration.models.models :as model]))


(defn montar-cpf
  "deviolve a pagina do CPF em PT-br"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu CPF"
                                          "precisamos do seu CPF para validar os dados")
                       (model/novo-input "string"
                                         "cpf"))



        bottom (model/novo-button "Continuar")]
    (model/nova-pagina children bottom)))

(defn montar-nome-br
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu nome"
                                          "por favor insira seu nome completo")
                       (model/novo-input "string"
                                         "name"))

        bottom (model/novo-button "Continuar")]
    (model/nova-pagina children bottom)))

(defn montar-email-br
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu email"
                                          "por favor informe um email valido")
                       (model/novo-input "string"
                                         "mail"))

        bottom (model/novo-button "Continuar" (model/nova-action "post" "/users" ["Procesando los datos" "Enviando su pedido" "Concluido"]))]
    (model/nova-pagina children bottom)))

(defn listar-paginas
  "Listar em ordem as paginas da aplicação"
  []
  (let [paginas (conj clojure.lang.PersistentQueue/EMPTY (montar-cpf) (montar-nome-br) (montar-email-br))]
    {:paginas paginas}))
