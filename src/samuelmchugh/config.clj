(ns samuelmchugh.config)

(def favicons
  [{:rel "apple-touch-icon"       :sizes "180x180" :href "/favicons/apple-touch-icon.png"}
   {:rel "icon" :type "image/png" :sizes "32x32"   :href "/favicons/favicon-32x32.png"}
   {:rel "icon" :type "image/png" :sizes "16x16"   :href "/favicons/favicon-16x16.png"}
   {:rel "icon" :type "image/png" :sizes "192x192" :href "/favicons/android-chrome-192x192.png"}
   {:rel "icon" :type "image/png" :sizes "512x512" :href "/favicons/android-chrome-512x512.png"}])

(def nav-bar
  [{:href "/"        :name "Home"}
   {:href "/contact" :name "Contact"}
   {:href "/other"   :name "Other"}
   {:href "/#development=1" :name "AMP Test"}]) ;; Temporary link for easily accessible AMP validation
   ;; Wont actually trigger validation by clicking the link hmm
