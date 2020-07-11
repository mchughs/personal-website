(ns samuelmchugh.sections.header.nav
  (:require
    [samuelmchugh.config :as config]))

(defn component []
  (let [nav-items (map (fn [{:keys [href name]}]
                         [:li [:a {:href href} name]])
                       config/nav-bar)]
    [:nav [:ul nav-items]]))
