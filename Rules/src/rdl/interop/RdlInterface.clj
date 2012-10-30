(ns rdl.interop.RDLInterface
  (:use [rdl.jpl]
        [rdl.rule])
  (:gen-class
    :state state
    :init init
    :methods [
              [printSomething [String] void]
              ]
    :constructors {[] []}
    ))

(defn -init
  "The initializer."
  []
  [[] (atom {})])


(defn -printSomething
  [this s]
  (println s "! YOU GOT IT!"))

;; TODO: Change this??
(defn -state
  [this]
  {})