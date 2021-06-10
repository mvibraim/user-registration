(ns user-registration.services.pages-test
  (:require [clojure.test :refer :all]
            [user-registration.services.pages :refer :all]))

(deftest get-pages-test
  (testing "Should return BR page"
    (let [country-code "br"
          page (get-pages country-code)
          page-country-code (:country-code page)]
      (is (= country-code page-country-code))))

  (testing "Should return MX page"
    (let [country-code "mx"
          page (get-pages country-code)
          page-country-code (:country-code page)]
      (is (= country-code page-country-code))))

  (testing "Should return CO page"
    (let [country-code "co"
          page (get-pages country-code)
          page-country-code (:country-code page)]
      (is (= country-code page-country-code))))

  (testing "Default page should be BR page"
    (let [page (get-pages 12345)
          page-country-code (:country-code page)]
      (is (= "br" page-country-code)))))
