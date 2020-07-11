(defproject samuelmchugh "0.1.0-SNAPSHOT"
  :description "samuelmchugh static frontend"
  :url "https://samuelmchugh.com/"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [stasis "2.5.0"]
                 [ring "1.8.1"]
                 [hiccup "1.0.5"]
                 [hiccup-bridge "1.0.1"]
                 [optimus "0.20.2"]
                 [environ "1.2.0"]]
  :ring {:handler samuelmchugh.web/app}
  :aliases {"export" ["with-profile" "prod" "run" "-m" "build.core/export"]}
  :source-paths ["src" "build-src"]
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "resources/public/beholder.js"
                                   :output-dir "resources/public/target"
                                   :optimizations :none
                                   :source-map true}}]}
  :profiles {:prod {:env {:dev false}}
             :dev {:env {:dev true}
                   :plugins [[lein-ring "0.12.5"]
                             [yogthos/lein-sass "0.1.10"]
                             [lein-pdo "0.1.1"]]}}
  :target-path "target/%s"
  :sass {:source "resources/public/sass"
         :target "target/resources/public/css"})
