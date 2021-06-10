(ns user-registration.services.users
  (:require [user-registration.services.country-pages.brpages :as brpages]
            [user-registration.services.country-pages.mxpages :as mxpages]
            [user-registration.services.country-pages.copages :as copages]
            [user-registration.logic.users-validations :as users-validations]))

(defn- get-page
  "Use the correct service according to the country"
  [country-code was-approved]
  (case country-code
    "br" (brpages/get-registration-result-page was-approved)
    "mx" (mxpages/get-registration-result-page was-approved)
    "co" (copages/get-registration-result-page was-approved)))

(defn validation
  "Validates the user input"
  [user-data]
  (let [country-code (:country-code user-data)
        was-approved (users-validations/valid-user? user-data)]
    (get-page country-code was-approved)))
