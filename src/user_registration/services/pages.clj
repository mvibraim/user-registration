(ns user-registration.services.pages
  (:require [user-registration.services.brpages :as brpages]
            [user-registration.services.mxpages :as mxpages]))

(defn get-pages 
  "select pages for a specific country"
  [country-code]
  (println country-code)
  (case country-code
    "mx" (mxpages/listar-paginas)
    ;; "co" {:status 200 :body (json/write-str (copages/listar-paginas))}
    (brpages/listar-paginas)
    ))