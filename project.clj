(defproject user-registration "0.1.0-SNAPSHOT"
  :description "Project to control user registration flux"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[com.stuartsierra/component "1.0.0"]
                 [io.pedestal/pedestal.service "0.5.9"]
                 [io.pedestal/pedestal.route "0.5.9"]
                 [io.pedestal/pedestal.jetty "0.5.9"]
                 [org.clojure/clojure "1.10.3"]
                 [org.clojure/data.json "2.3.1"]
                 [org.slf4j/slf4j-simple "1.7.30"]]
  :main ^:skip-aot user-registration.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
