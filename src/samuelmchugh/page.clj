(ns samuelmchugh.page
  (:require
    [hiccup.page :as hiccup]
    [samuelmchugh.components.favicons :as favicons]
    [samuelmchugh.sections.header.core :as header]
    [samuelmchugh.sections.contact.core :as contact]
    [samuelmchugh.sections.resume.core :as resume]
    [samuelmchugh.sections.history.core :as history]
    [samuelmchugh.sections.footer.core :as footer]))

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

     (favicons/component request)]

    [:body
     (header/section request)
     [:div.content
      (contact/section)
      (resume/section)
      (history/section)]
     (footer/section)]))
