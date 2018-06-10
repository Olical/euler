(ns p-0003)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn div-by? [x y]
  (zero? (mod x y)))

(defn is-prime? [n]
  (loop [t (dec n)]
    (cond
      (= t 1) true
      (< t 1) false
      (div-by? n t) false
      :else (recur (dec t)))))

(def primes (filter is-prime? (range)))

(defn prime-factors [n]
  (loop [[prime & primes] primes
         acc []]
    (cond
      (is-prime? n) (conj acc n)
      (div-by? n prime) (into (conj acc prime) (prime-factors (/ n prime)))
      :else (recur primes acc))))

(comment
  (last (prime-factors 13195))
  (last (prime-factors 600851475143)))
