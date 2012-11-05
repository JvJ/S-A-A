
(use 'rdl.rule)
(use 'rdl.jpl)

(defrel 'smack [:INST :TARG])
(defrel 'anger [:SELF :VAL])

(defrule
  'getsmacked
  (rel 'smack {:INST :I :TARG :T})
  (rel 'anger {:SELF :T :VAL :V})
  :==>
  {:V2 (fn [m] (+ (m :V) 0.1))}
  :==>
  (mod-rels 'anger {:SELF :T} {:VAL :V2}))