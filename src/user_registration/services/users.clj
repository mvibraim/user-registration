(ns user-registration.services.users)

(defn valid? [user-data]
  (let [country-code (:country-code user-data)])
  true)