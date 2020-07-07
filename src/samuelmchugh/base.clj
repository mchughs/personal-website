(ns samuelmchugh.base
  (:require
    [optimus.link :as o.link]
    [hiccup.page :as hiccup]))

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
     [:noscript
      [:style {:amp-boilerplate true} (slurp "resources/public/css/amp-noscript.css")]]

     [:link {:rel "canonical" :href "https://www.samuelmchugh.com/"}]

     ; Favicons
     [:link {:rel "apple-touch-icon"       :sizes "180x180" :href (o.link/file-path request "/favicons/apple-touch-icon.png")}]
     [:link {:rel "icon" :type "image/png" :sizes "32x32"   :href (o.link/file-path request "/favicons/favicon-32x32.png")}]
     [:link {:rel "icon" :type "image/png" :sizes "16x16"   :href (o.link/file-path request "/favicons/favicon-16x16.png")}]
     [:link {:rel "icon" :type "image/png" :sizes "192x192" :href (o.link/file-path request "/favicons/android-chrome-192x192.png")}]
     [:link {:rel "icon" :type "image/png" :sizes "512x512" :href (o.link/file-path request "/favicons/android-chrome-512x512.png")}]]

    [:body
     [:div.logo "samuelmchugh"]
     [:div.hero
      [:div.container
       [:h1 "samuelmchugh"]]]
     [:div.container
      [:div.body page]]
     [:footer.container "Copyright &copy; 2020 samuelmchugh"]]))
