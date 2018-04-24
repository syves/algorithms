(ns "euler-problem-10")
;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of (all the primes below two million).

;A. find factors
;B. find a prime
;C. find next prime

(defn factors? [num] (map (partial / num) (range 1 (inc num))))

(factors? 1) ;(1)
(factors? 2) ;(2 1)
(factors? 6) ;(6 3 2 3/2 6/5 1)
(factors? 7) ;(7 7/2 7/3 7/4 7/5 7/6 1)

(defn prime? [num]
             (if (= num 1)
                 false
                 (empty? (remove #{list num 1} (filter integer? (factors? num))))))
(prime? 1) ;false
(prime? 2) ;true
(prime? 7) ;true
(prime? 6) ;false
(prime? 10000) ;false

(defn getNextPrime
  [num]
  (loop [num num]
    (let [maybe-prime (inc num)]
      (if (prime? maybe-prime)
          maybe-prime
          (recur maybe-prime)))))
(getNextPrime 0) ;2
(getNextPrime 7) ;11
(getNextPrime 6) ;7

(defn sumPrimes
  [max-num]
  (loop [curr-total 0 curr-prime 0]
       (let [next-prime (getNextPrime curr-prime)
             next-total (+ curr-total next-prime)]
              (if (< next-total max-num)
                  (recur next-total next-prime)
                  curr-total))))

(sumPrimes 18)
