(ns p-0006)

;; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

(defn square [n]
  (* n n))

(defn sums-squares [[sums squares] n]
  [(+ sums n) (+ squares (square n))])

(time
  (let [[sums squares] (reduce sums-squares [0 0] (range 1 101))]
    (- (square sums) squares)))
