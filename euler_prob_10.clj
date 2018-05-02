(ns euler_problem_10)
  ;(:require [clojure.math.numeric-tower :as math]))

;The sum of the primes below n. is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of primes below two million).

;TODO nested ifs are gross, why isnt there an else if?
;TODO make prime check faster. Prime numbers have an irrational root, but there is no irrational type in Java that I can find. And one cannot simply square the root of n and compare it to N, because of precision loss on non primes as well.

(defn faster-prime? [mp]
  (empty?
  (loop [maybe-prime mp maybe-factor 2 factors []]
    ;(println maybe-prime maybe-factor)
    (if (= false (empty? factors)) ;we found the first factor, escape loop
      factors
      (if (< maybe-factor (dec maybe-prime)) ;the prime itself would be a factor which we dont wan to capture
        (recur maybe-prime
               (inc maybe-factor)
               (if (= 0 (mod maybe-prime maybe-factor))
                         (cons maybe-factor factors);found
                         factors));not found
        factors))))) ;looked at all the factors, return results

(faster-prime? 17) ; true
(faster-prime? 18) ;false

(defn next-prime
  [num]
  (loop [numbr num]
    (let [maybe-prime (inc numbr)]
      (if (faster-prime? maybe-prime)
          maybe-prime
          (recur maybe-prime)))))

;Int -> Int
(defn sum-primes
  [num]
  (loop [num-primes num sum 0 curr-prime 2]
    (if (zero? num-primes)
        sum
        (recur (dec num-primes) (+ sum curr-prime) (next-prime curr-prime)))))

(defn n-primes-lazy [prime] (lazy-seq (cons prime (n-primes-lazy (next-prime prime)))))
(take 5 (n-primes-lazy 2)) ;(2 3 5 7 11)
(reduce + (take 5 (n-primes-lazy 2)))

;this is not really a good case for laziness just we know exactly how many we want
(defn lazy-sum-primes [num-primes] (reduce + (take num-primes (n-primes-lazy 2))))
(lazy-sum-primes 1000)
(lazy-sum-primes 10000) ;slightly over 2 minutes

; Int -> Int -> List Double
;why cant I access Math/pow when it is inside partial and map?
;(defn n-multiples [num-multiples num]
;  (map
;      (partial ((memfn Math/pow) (double num)))
;      (range 2.0 (inc num-multiples)) ))
;(n-multiples 2 3)

(sum-primes 4)
(sum-primes 5)
;(sum-primes 1000)
;(sum-primes 10000); around 2 minutes
;(sum-primes 2000000)