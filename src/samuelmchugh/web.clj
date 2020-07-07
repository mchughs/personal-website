(ns samuelmchugh.web
  (:require
    [optimus.assets :as assets]
    [optimus.link :as link]
    [optimus.optimizations :as optimizations]
    [optimus.prime :as optimus]
    [samuelmchugh.base :as base]
    [samuelmchugh.utils :as utils]
    [optimus.strategies :refer [serve-live-assets serve-frozen-assets]]
    [clojure.java.io :refer [resource]]
    [clojure.java.io :as io]
    [stasis.core :as stasis]
    [environ.core :refer [env]]
    [hiccup.page :as hiccup]
    [hiccup-bridge.core :as hicv]))

(def dev? (env :dev)) ;;TODO NEEDS TO BE FIXED
; enable reloadable config

(defn get-assets []
  (assets/load-assets "public" [;#"/fonts/.+" TODO reintroduce once we have fonts
                                #"/favicons/.+"]))

(defn get-pages []
  (stasis/merge-page-sources
   {:public (stasis/slurp-directory "resources/public" #".*\.(html|css|js)$")
    :partials (->> (stasis/slurp-directory "resources/partials" #".*\.html$")
                   (utils/map-v #(partial base/page %)))
    :pages (->> (stasis/slurp-directory "src/samuelmchugh/pages" #".*\.clj$")
                (utils/map-v read-string)
                (utils/map-v hicv/hiccup->html)
                (utils/map-v #(partial base/page %))
                (utils/map-k #(clojure.string/replace % #"\.clj$" "/index.html")))}))

(def app
  (optimus/wrap
    (stasis/serve-pages get-pages)
    get-assets
    (if dev? optimizations/none optimizations/all)  ;;TODO NEEDS TO BE FIXED
    (if dev? serve-live-assets serve-frozen-assets)))  ;;TODO NEEDS TO BE FIXED
