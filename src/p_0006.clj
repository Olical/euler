(ns p-0006)

;; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

(defn square [n]
  (* n n))

(let [nats (range 1 101)
      sum-square (->> nats (map square) (reduce +))
      square-sum (->> nats (reduce +) square)]
  (- square-sum sum-square))
