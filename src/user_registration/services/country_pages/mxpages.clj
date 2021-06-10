(ns user-registration.services.country-pages.mxpages
  (:require [user-registration.models.models :as model]))
🇲🇽
(defn montar-main-mx
  "devolve a pagina inicial em es-mx"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Boas vindas ao Nubank!"
                                          "Nu hace más sencilla tu vida financiera")
                       (model/novo-select [(model/novo-combo-item "Brasil" "br")
                                           (model/novo-combo-item "Mexico" "mx")
                                           (model/novo-combo-item "Colombia" "co")]))
        bottom (conj clojure.lang.PersistentQueue/EMPTY (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-rfc
  "deviolve a pagina do RFC mexico"
  []
  (let [children (conj clojure.lang.PersistentQueue/EMPTY
                       (model/novo-header "Cuál es tu RFC"
                                          "necesitamos su RFC para validar los datos")
                       (model/novo-input "string"
                                         "rfc"))




        bottom (conj clojure.lang.PersistentQueue/EMPTY
                     (model/novo-button "Continuar"))]
    (model/nova-pagina children bottom)))

(defn montar-nome-mx
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

(defn montar-email-mx
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
  (let [paginas (conj clojure.lang.PersistentQueue/EMPTY (montar-main-mx) (montar-rfc) (montar-nome-mx) (montar-email-mx))]
    {:paginas paginas}))
