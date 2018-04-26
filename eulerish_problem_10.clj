(ns "eulerish_problem")
;The sum of the primes below n, where n is 18. is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of primes, whose total is below two million).

;A. find factors
;B. find a prime
;C. find next prime

(defn factors [num] (map (partial / num) (range 1 (inc num))))

(do
  (assert (= '(1) (factors 1)) "factors of 1: (1)")
  (assert (= '(2 1) (factors 2)) "factors of 2: (2 1)")
  (assert (= '(6 3 2 3/2 6/5 1) (factors 6)) "factors of 6: (6 3 2 3/2 6/5 1)")
  (assert (= '(7 7/2 7/3 7/4 7/5 7/6 1) (factors 7))
          "factors of 6: (7 7/2 7/3 7/4 7/5 7/6 1)"))

(defn prime? [num]
             (if (= num 1)
                 false
                 (empty? (remove #{num 1} (filter integer? (factors num))))))

(do
  (assert (= false (prime? 1)))
  (assert (= true (prime? 2)))
  (assert (= false (prime? 6)))
  (assert (= true (prime? 7)))
  (assert (= false (prime? 1000))))

;if you feel you need to loop recur try using reduce or map.
(defn get-next-prime
  [num]
  (loop [numbr num]
    (let [maybe-prime (inc numbr)]
      (if (prime? maybe-prime)
          maybe-prime
          (recur maybe-prime)))))
(do
  (assert (= 2 (get-next-prime 0))
  (assert (= 11 (get-next-prime 7))
  (assert (= 7 (get-next-prime 6)))

(defn sum-primes
  [max-num]
  (loop [curr-total 0 curr-prime 0]
       (let [next-prime (get-next-prime curr-prime)
             next-total (+ curr-total next-prime)]
            (if (< next-total max-num)
              (recur next-total next-prime)
                curr-total))))

(assert (= 17 (sum-primes 18))
(assert (= 1999236 (sum-primes 2000000000))
