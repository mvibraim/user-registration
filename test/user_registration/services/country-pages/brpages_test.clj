(ns user-registration.services.country-pages.brpages-test
  (:require [clojure.test :refer :all]
            [user-registration.services.country-pages.brpages :refer :all]
            [user-registration.test-helper :as helper]))

(deftest list-ordered-pages-test
  (testing "Should return 1 page"
    (let [page-ordering [:document]
          ordered-pages (:pages (list-ordered-pages page-ordering))]
      (is (= 1 (count ordered-pages)))))

  (testing "Should return 2 pages"
    (let [page-ordering [:document :name]
          ordered-pages (:pages (list-ordered-pages page-ordering))]
      (is (= 2 (count ordered-pages)))))

  (testing "Should return 3 pages"
    (let [page-ordering [:document :name :birth-date]
          ordered-pages (:pages (list-ordered-pages page-ordering))]
      (is (= 3 (count ordered-pages)))))

  (testing "Should return 4 pages"
    (let [page-ordering [:document :name :birth-date :email]
          ordered-pages (:pages (list-ordered-pages page-ordering))]
      (is (= 4 (count ordered-pages)))))

  (testing "Should return ordered page with the following sequence: document name birth-date email"
    (let [page-ordering [:document :name :birth-date :email]
          ordered-pages (:pages (list-ordered-pages page-ordering))
          ordered-page-names (helper/get-page-names ordered-pages)]
      (is (= ["document" "name" "birth-date" "email"] ordered-page-names))))

  (testing "Should return ordered page with the following sequence: email name"
    (let [page-ordering [:email :name]
          ordered-pages (:pages (list-ordered-pages page-ordering))
          ordered-page-names (helper/get-page-names ordered-pages)]
      (is (= ["email" "name"] ordered-page-names)))))
