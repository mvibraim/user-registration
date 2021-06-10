(ns user-registration.services.country-pages.mxpages-test
  (:require [clojure.test :refer :all]
            [user-registration.services.country-pages.mxpages :refer :all]))

(deftest list-ordered-pages-test
  (testing "Should return 1 page"
    (let [page-ordering [:document]
          ordered-pages (:pages (listar-paginas page-ordering))]
      (is (= 1 (count ordered-pages)))))

  (testing "Should return 2 page"
    (let [page-ordering [:document :name]
          ordered-pages (:pages (listar-paginas page-ordering))]
      (is (= 2 (count ordered-pages)))))
  (testing "Should return 3 page"
    (let [page-ordering [:document :name :date]
          ordered-pages (:pages (listar-paginas page-ordering))]
      (is (= 3 (count ordered-pages)))))
  (testing "Should return 4 page"
    (let [page-ordering [:document :name :date :email]
          ordered-pages (:pages (listar-paginas page-ordering))]
      (is (= 4 (count ordered-pages))))))
