(ns user-registration.test-helper)

(defn get-page-names [pages]
  (map #(:name %) pages))
