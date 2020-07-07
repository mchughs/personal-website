(ns samuelmchugh.utils)

(defn map-v
  "Only apply f to the values of the supplied map."
  [f m]
  (zipmap (keys m)
          (map f (vals m))))

(defn map-k
  "Only apply f to the keys of the supplied map."
  [f m]
  (zipmap (map f (keys m))
          (vals m)))
