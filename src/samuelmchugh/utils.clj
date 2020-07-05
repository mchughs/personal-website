(ns samuelmchugh.utils)

(defn map-v
  "Only apply f to the values of the supplied map."
  [f m]
  (zipmap (keys m)
          (map f (vals m))))
