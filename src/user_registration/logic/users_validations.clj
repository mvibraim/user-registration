(ns user-registration.logic.users-validations
  (:require [clojure.string :as str]))

(defn nubanker? [user-data]
  (if-let [email (:email user-data)]
    (str/includes? email "@nubank.com.br")))

(defn valid-name? [user-data]
  (if-let [name (:name user-data)]
    (>= (count name) 3)
    true))

(defn valid-document? [user-data]
  (if-let [document (:document user-data)]
    (-> document
        str
        (str/starts-with? "0")
        not)))

(defn valid-birthday? [user-data]
  (if-let [birthday (:birthday user-data)]
    (-> birthday
        (str/split #"/")
        second
        (not= "07"))
    true))

(defn valid-email? [user-data]
  (if-let [email (:email user-data)]
    (str/includes? email "@")))

(defn valid-user? [user-data]
  (->> user-data
       ((juxt valid-name?
              valid-document?
              valid-birthday?
              valid-email?
              nubanker?))
       (every? true?)))
