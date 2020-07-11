(ns samuelmchugh.web
  (:require
    [clojure.java.io :as io]
    [clojure.java.io :refer [resource]]
    [environ.core :refer [env]]
    [hiccup-bridge.core :as hicv]
    [hiccup.page :as hiccup]
    [optimus.assets :as assets]
    [optimus.link :as link]
    [optimus.optimizations :as optimizations]
    [optimus.prime :as optimus]
    [optimus.strategies :refer [serve-live-assets serve-frozen-assets]]
    [samuelmchugh.page :as page]
    [samuelmchugh.utils :as utils]
    [stasis.core :as stasis]))

(def dev? true) ;;TODO NEEDS TO BE FIXED

(defn get-assets []
  (assets/load-assets "public" [#"/fonts/.+"
                                #"/images/.+"
                                #"/favicons/.+"]))

(defn get-pages []
  (stasis/merge-page-sources
   {:public (stasis/slurp-directory "resources/public" #".*\.(html|css|js)$")
    :partials (->> (stasis/slurp-directory "resources/partials" #".*\.html$")
                   (utils/map-v #(partial page/page %)))}))
    ; :pages (->> (stasis/slurp-directory "src/samuelmchugh/pages" #".*\.clj$")
    ;             (utils/map-v read-string)
    ;             (utils/map-v hicv/hiccup->html)
    ;             (utils/map-v #(partial page/page %))
    ;             (utils/map-k #(clojure.string/replace % #"\.clj$" "/index.html")))}))

(def app
  (optimus/wrap
    (stasis/serve-pages get-pages)
    get-assets
    (if dev? optimizations/none optimizations/all)  ;;TODO NEEDS TO BE FIXED
    (if dev? serve-live-assets serve-frozen-assets)))  ;;TODO NEEDS TO BE FIXED
