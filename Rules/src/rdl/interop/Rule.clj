(ns rdl.interop.RDLRule
  (:use [rdl.jpl]
        [rdl.rule])
  (:gen-class
    :prefix "rl-"
    :init init
    :state state
    :methods []
    :constructors {[String] []}))

(defn rl-init
  "The constructor!"
  [s]
  [[] [(symbol s) (@*rules* (symbol s))]])

(defn rl-toString
  [this]
  (str (.state this)))
