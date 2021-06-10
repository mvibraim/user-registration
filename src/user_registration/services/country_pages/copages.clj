(ns user-registration.services.country-pages.copages
  (:require [user-registration.models.models :as model]))


(defn montar-main-co
  "devolve a pagina inicial em es-co"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Boas vindas ao Nubank!"
                                          "Nu hace tu vida fianciera más sencilla")
                       (model/novo-select [(model/novo-combo-item "Brasil" "br")
                                           (model/novo-combo-item "Mexico" "mx")
                                           (model/novo-combo-item "Colombia" "co")]))
        bottom (conj clojure.lang.PersistentQueue/EMPTY (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-nni
  "deviolve a pagina do número de Identificación Nacional - Colombia "
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Cuál es tu Cual es tu Número de Identificación Nacional"
                                          "necesitamos su Número de Identificación Nacional")
                       (model/novo-input "string"
                                         "nni"))




        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-nome-co
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Introduzca su nombre"
                                          "Por favor ingresa tu nombre completo")
                       (model/novo-input "string"
                                         "nombre"))

        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-email-co
  "pagina do nome completo"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Introduce tu correo electronico"
                                          "Por favor introduzca una dirección de correo electrónico válida")
                       (model/novo-input "string"
                                         "mail"))

        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar" (model/nova-action "post" "/register")))]
    (model/nova-pagina children bottom)))

(defn listar-paginas
  "Listar em ordem as paginas da aplicação"
  []
  (let [paginas (conj clojure.lang.PersistentQueue/EMPTY (montar-main-co) (montar-nni) (montar-nome-co) (montar-email-co))]
    {:paginas paginas}))
