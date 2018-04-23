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

;while sum is <2 million find the next prime and add it to acc

;how to find the next prime? add one to the current number and check to see
;if it is primes

(= false (prime? (inc 6)))

;is there a specicial case for 1?
;let [m-prime (+ curr-prime 1)]
(defn maybe-prime [num](inc num))
(defn getNextPrime
  [num]
  ;if it is not prime  find the next prime else return the prime
  (if (= false (prime? (inc num))) (getNextPrime num) (inc num)))

(getNextPrime 7)

(defn sumPrimes
  [max-num]
  (let [acc 0]
    if (< acc max-num) (if prime? (+ acc 1)) (+ acc curremtPrime)  )    acc ) )
