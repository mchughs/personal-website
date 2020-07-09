(ns samuelmchugh.base
  (:require
    [optimus.link :as o.link]
    [hiccup.page :as hiccup]
    [samuelmchugh.config :as config]))

(defn- gen-favicon-links [request]
  (->> config/favicons
       (map #(update % :href (partial o.link/file-path request)))
       (map #(conj [:link] %))))

(defn- gen-nav-bar-anchors []
  (->> config/nav-bar
       (map (fn [{:keys [href name]}]
              [:a {:href href} name]))))

(defn page [page request]
  (hiccup/html5
    {:amp true
     :lang "en"}
    [:head
     [:meta {:charset "utf-8"}]
     [:script {:async true
               :src "https://cdn.ampproject.org/v0.js"}]
     [:title "Samuel Mchugh: Web Developer"]
     [:meta {:name "viewport"
             :content "width=device-width, initial-scale=1.0"}]
     [:script {:type "application/ld+json"}
              "{
               \"@context\": \"http://schema.org\",
               \"@type\": \"NewsArticle\",
               \"headline\": \"Open-source framework for publishing content\",
               \"datePublished\": \"2015-10-07T12:02:41Z\",
               \"image\": []
                 \"logo.jpg\"
               }"]

     ; Inline Styles
     [:style {:amp-boilerplate true} (slurp "resources/public/css/amp.css")]
     [:style {:amp-custom true} (slurp "target/resources/public/css/style.css")]
     [:noscript
      [:style {:amp-boilerplate true} (slurp "resources/public/css/amp-noscript.css")]]

     [:link {:rel "canonical" :href "https://www.samuelmchugh.com/"}]

     ; Web-Browser bar Chrome, Firefox OS and Opera
     [:meta {:name "theme-color" :content "#4285f4"}] ;; TODO decide on a color
     ; Web-Browser bar iOS Safari
     [:meta {:name "apple-mobile-web-app-status-bar-style" :content "#4285f4"}] ;; TODO decide on a color

     ; Favicons
     (gen-favicon-links request)]

    [:body
     [:div.hero
      [:div.container
       [:h1 "samuelmchugh"]]]
     [:nav (gen-nav-bar-anchors)]
     [:div.container
      [:div.body page]]
     [:footer.container "Copyright &copy; 2020 samuelmchugh"]]))
