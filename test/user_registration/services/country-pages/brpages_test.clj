(ns user-registration.services.country-pages.brpages-test
  (:require [clojure.test :refer :all]
            [user-registration.services.country-pages.brpages :refer :all]))

(defn get-pages-name [pages]
  ())

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

  (testing "Should return ordered page as the ordering list"
    (let [page-ordering [:document :name :birth-date :email]
          ordered-pages (:pages (list-ordered-pages page-ordering))]
      (is (= ["document" "name" "birth-date" "email"] (count ordered-pages))))))
