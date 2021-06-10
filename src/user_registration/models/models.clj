(ns user-registration.models.models)

(defn new-page [children bottom name]
  {:children children
   :bottom   bottom
   :name     name})

(defn new-header
  "NuDS header"
  [title subtitle]
  {:type     "Header"
   :title    title
   :subtitle subtitle})

(defn new-input
  "NuDS input"
  ([keyboard id]
   (new-input keyboard id nil))
  ([keyboard id format]
   {:type     "Input"
    :keyboard keyboard
    :id       id
    :format   format}))

(defn new-button
  "NuDS button"
  ([text]
   {:type "BottomButton"
    :text text})
  ([text action]
   {:type   "BottomButton"
    :text   text
    :action action}))

(defn new-action
  "Represents an action from button"
  [method uri steps]
  {:method method
   :uri    uri
   :steps  steps})

(defn new-go-to-home
  "Goto home"
  (new-action "post" "go-to-home" []))

(defn new-image
  "NuDS image"
  [src]
  {:type "Image"
   :src  src})
