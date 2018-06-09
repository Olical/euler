(ns p-0001)

;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn multiple-of-fn? [x]
  (fn [y]
    (zero? (mod y x))))

(->> (range 1000)
     (filter (some-fn (multiple-of-fn? 3) (multiple-of-fn? 5)))
     (reduce +))
