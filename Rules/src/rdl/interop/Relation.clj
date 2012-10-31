(ns rdl.interop.RDLRelation
  (:use [rdl.jpl]
        [rdl.rule])
  (:gen-class
    :prefix "relt-"
    :init init
    :state state
    :methods [
              [getName [] String]
              [getFields [] "[Ljava.lang.Object;"]
              [term [ "[Ljava.lang.Object;"] Object]
              [assertRel [ "[Ljava.lang.Object;"] Object]
              [retractRel [ "[Ljava.lang.Object;"] clojure.lang.Seqable]
              ]
    :constructors {[String] []}))

(defn relt-init
  "The constructor!"
  [s]
  [[] [(symbol s) (@*relations* (symbol s))]])

(defn relt-toString
  [this]
  (str (.state this)))

(defn relt-getName
  [this]
  (first (.state this)))

(defn relt-getFields
  [this]
  (map name (:unfields (second (.state this)))))

(defn term-retract-assert
  [this f objs]
  (println "objs: " (vec objs))
  (println "parobs: " (partition 2 objs))
  (println "theState : " (first (.state this)))
  (let [res 
  (f (first (.state this))
     (apply hash-map
            (mapcat
              #(vector (keyword (first %))
                       (if (string? (second %))
                         (read-string (second %))
                         (second %)))
              (partition 2 objs))))
  _ (println res)
     ]
    res))

(defn relt-term
  [this objs]
  (term-retract-assert this rel objs))

(defn relt-assertRel
  [this objs]
  (term-retract-assert this assert-rel objs))

(defn relt-retractRel
  [this objs]
  (term-retract-assert this retract-rel objs))

 
       