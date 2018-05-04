(ns euler_problem_10)
  ;(:require [clojure.math.numeric-tower :as math]))

;The sum of the primes below n. is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of primes below two million).

;TODO nested ifs are gross, why isnt there an else if?
;TODO make prime check faster.
;1. only search up to the square root of n,
;only need to fnd the smaller member of the pair of the composite number.
;2. store primes we find in a dictionary but why? if n is divisible by the prime then we dont have to check for any other factors.
;ex n= 1764 , 42 * 42,  mod  42 7 = 0, 7 x 6 = 42,
;fatcors of 42 = (42 21 14 7 6 3 2 1)
;we would check 2,3,5,7 with new optamization
;without would be 2, for non primes.

;what about a prime?
;541 sqrt 541 ~ 23.0,
;huge work reduction here.
;to find the next factor we would check
;everytime we check primes that we have already found: 2,3,5,7,11,17,19
;we check (2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21, 22)
;in this case we reduce the work by at 1/4,

;Int -> Boolean
;TODO add factors map as an argument to loop

(defn faster-prime? [maybe-prime]
  (loop [maybe-factor 2]
      (or (> maybe-factor (Math/sqrt maybe-prime))
          (if-not (= 0 (mod maybe-prime maybe-factor))
              (recur (inc maybe-factor))
              false))))
;(defn prime2) try storing primes...

(faster-prime? 5)
(faster-prime? 17) ; true
(faster-prime? 18) ;false

;finds a single prime number
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
(take 100 (n-primes-lazy 2))
(reduce + (take 5 (n-primes-lazy 2)))

;this is not really a good case for laziness just we know exactly how many we want
(defn lazy-sum-primes [num-primes] (reduce + (take num-primes (n-primes-lazy 2))))
(lazy-sum-primes 1000)
(lazy-sum-primes 10000) ;2 sec 489521294
(lazy-sum-primes 2000000)

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
(sum-primes 10000)
;(sum-primes 2000000)
