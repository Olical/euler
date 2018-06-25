(ns p-0005)

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn divides? [x y]
  (zero? (mod x y)))

(defn divides-evenly-into-range? [n x]
  (loop [n n]
    (cond
      (zero? n) true
      (divides? x n) (recur (dec n))
      :else false)))

(defn smallest-divides [n]
  (loop [x 1]
    (if (and (even? x) (divides-evenly-into-range? n x))
      x
      (recur (inc x)))))

(comment
  (require '[clojure.test :as t])
  (smallest-divides 10)
  (t/is (= (smallest-divides 20) 232792560)))
