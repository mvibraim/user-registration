(ns user-registration.logic.users-validations-test
  (:require [clojure.test :refer :all]
            [user-registration.logic.users-validations :refer :all]))

(deftest valid-name?-test
  (testing "Should return true for a valid name"
    (is (valid-name? {:name "David"})))

  (testing "Should return false for a invalid name"
    (is (not (valid-name? {:name "Oi"})))))

(deftest valid-birthday?-test
  (testing "Should return true for a valid birthday"
    (is (valid-birthday? {:birthday "10/12/2000"})))

  (testing "Should return false for a invalid birthday"
    (is (not (valid-birthday? {:birthday "01/07/2000"})))))

(deftest valid-document?-test
  (testing "Should return true for a valid document"
    (is (valid-document? {:document "123.456.789.10"})))

  (testing "Should return false for a invalid document or nil"
    (is (not (valid-document? {:document "012.345.678-91"})))
    (is (not (valid-document? {:name "David"})))))

(deftest valid-email?-test
  (testing "Should return true for a valid email"
    (is (valid-email? {:email "david@gmail.com"})))

  (testing "Should return false for a invalid email or nil"
    (is (not (valid-email? {:email "david.gmail.com"})))
    (is (not (valid-email? {:name "David"})))))

(deftest nubanker?-test
  (testing "Should return true for a nubank email"
    (is (nubanker? {:email "david@nubank.com.br"})))

  (testing "Should return false for a others emails or nil"
    (is (not (nubanker? {:email "david@gmail.com"})))
    (is (not (nubanker? {:name "david"})))))

(deftest valid-user?-test
  (testing "Should return true for a valid user"
    (is (valid-user? {:name         "David Velez"
                      :birthday     "18/08/1980"
                      :email        "david.velez@nubank.com.br"
                      :document     "987.654.321-23"
                      :country-code "co"})))

  (testing "Should return false for a invalid user"
    (is (not (valid-user? {:name         "David Velez"
                           :birthday     "18/08/1980"
                           :email        "david.velez@nubank.com.br"
                           :document     "087.654.321-23"
                           :country-code "co"})))))

