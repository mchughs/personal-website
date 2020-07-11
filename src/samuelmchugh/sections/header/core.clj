(ns samuelmchugh.sections.header.core
  (:require
    [samuelmchugh.sections.header.logo :as logo]
    [samuelmchugh.sections.header.nav :as nav]))

(defn section [request] ;; TODO add dynamic language switch
  [:header.sticky
   (logo/component request)
   (nav/component)])
