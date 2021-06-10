(ns user-registration.services.country-pages.brpages
  (:require [user-registration.models.models :as model]))

(defn montar-cpf
  "deviolve a pagina do CPF em PT-br"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Informe seu CPF"
                                          "precisamos do seu CPF para validar os dados")
                       (model/novo-input "number"
                                         "cpf"
                                         "000.000.000-00"))

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

        bottom (model/novo-button "Continuar" (model/nova-action "post" "/users" ["Processando os dados" "Enviando seu pedido" "Concluído"]))]
    (model/nova-pagina children bottom)))

(defn montar-data-nascimento
  "pagina que pede a data de nascimento"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Preciso da sua data de nascimento"
                                          "indorme o dia/mes/ano")
                       (model/novo-input "datetime"
                                         "birthday"
                                         "00/00/0000"))
        bottom (model/novo-button "Continuar")]
    (model/nova-pagina children bottom)))

(def page-builders
  {:document montar-cpf
   :name montar-nome-br
   :date montar-data-nascimento
   :email montar-email-br})

(defn listar-paginas
  "Listar em ordem as paginas da aplicação"
  [page-ordering]
  (let [ordered-pages (map #((% page-builders)) page-ordering)]
    {:pages ordered-pages :country-code "br"}))
