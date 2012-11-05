(ns misc.core)

;;;; These are some miscellaneous utility functions!

(defn ><
  "Flips the order of application of a function!"
  [f]
  (fn [& args]
    (apply f (reverse args))))

(def $ partial)

(def $> apply)

(def $+ comp)

(def +$ (>< comp))

