(ns "euler-problem-10")
;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;Find the sum of all the primes below two million.

;1. find a prime

(defn factors? [num] (map (partial / num) (range 1 (inc num))))
;(factors? 6) ;(6 3 2 3/2);[6,3,2]
;(factors? 7) ;(7 7/2 7/3 7/4 7/5)

(defn prime? [num] (empty? (remove #{num} (filter integer? (factors? num)))))

(prime? 7) ;true
(prime? 6) ;false
(prime? 10000)

;while sum is <2 million find the next prime and add it to acc

;if it is not prime  find the next prime else return the prime
(defn getNextPrime
  [num]
  (loop [num num]
    (let [maybe-prime (inc num)]
      (if (prime? maybe-prime)
          maybe-prime
          (recur maybe-prime)))))

(getNextPrime 7);"false 8"
(getNextPrime 6);"true 7"

(defn sumPrimes
  [max-num]
  (let [acc 0
        num 0]
    if (< acc max-num) (+ acc (getNextPrime num))) (+ acc curremtPrime)) acc) )
