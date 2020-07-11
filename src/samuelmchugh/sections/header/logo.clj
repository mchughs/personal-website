(ns samuelmchugh.sections.header.logo
  (:require
    [optimus.link :as o.link]
    [samuelmchugh.config :as config]))

(defn component [request]
  [:amp-img.logo
   {:src (o.link/file-path request "/images/logo-placeholder-300x210.jpg")
    :layout "responsive"
    :width "20"
    :height "20"}])
