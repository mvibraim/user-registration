(ns user-registration.models.models)

(defn nova-pagina [children bottom]
  {:children children
   :bottom bottom})

(defn novo-header
  "Nudes Header"
  [title subtitle]
  {:type "Header"
   :title title
   :subtitle subtitle})

(defn novo-input
  "NudesInput"
  [keyboard id]
  {:type "Input"
   :keyboard keyboard
   :id id})

(defn novo-button
  "Nudes button"
  ([text]
   {:type "BottomButton"
    :text text})
  ([text action]
   {:type "BottomButton"
    :text text
    :action action}))

(defn nova-action
  "represent a action from button"
  [method uri steps]
  {:method method
   :uri uri
   :steps steps})

(defn novo-combo-item
  "returns a drop down item"
  [texto valor]
  {:text texto
   :value valor})

(defn novo-select
  "return a select drop down"
  [combo-items]
  {:type "combo"
   :items combo-items})