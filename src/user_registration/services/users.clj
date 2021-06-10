(ns user-registration.services.users)

(defn valid?
  "Validates the user input"
  [user-data]
  (let [country-code (:country-code user-data)])
  true)
