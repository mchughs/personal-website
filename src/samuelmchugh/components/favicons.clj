(ns samuelmchugh.components.favicons
  (:require
    [optimus.link :as o.link]
    [samuelmchugh.config :as config]))

(defn component [request]
  (->> config/favicons
       (map #(update % :href (partial o.link/file-path request)))
       (map #(conj [:link] %))))
