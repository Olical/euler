(ns p-0004)

;; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [n]
  (let [cs (seq (str n))]
    (= cs (reverse cs))))

(let [r (range 100 1000)
      ps (for [x r
               y r
               :let [p (* x y)]
               :when (palindrome? p)]
           p)]
  (reduce max ps))
