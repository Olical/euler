(ns p-0003)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn divides? [n d]
  (zero? (mod n d)))

(defn divide-down [n p d]
  (if (divides? n d)
    (recur (/ n d) d d)
    [n p]))

(defn largest-prime-factor [n]
  (let [[n p] (divide-down n -1 2)
        limit (-> (Math/sqrt n) (inc) (int))]
    (loop [[n p] [n p]
           odds (range 3 limit 2)]
      (if-let [odd (first odds)]
       (recur (divide-down n p odd) (rest odds))
        (max n p)))))

(comment
  (largest-prime-factor 13195)
  (largest-prime-factor 600851475143))
