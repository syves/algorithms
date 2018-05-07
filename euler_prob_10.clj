(ns euler_problem_10)
  ;(:require [clojure.math.numeric-tower :as math]))

;The sum of the primes below n. is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of primes below two million).

;primes -> primes
(defn memo-prime [primes]
    (loop [maybe-prime (inc (last primes))]
      (if (every? (fn [x] (not= 0 (mod maybe-prime x))) primes)
          (conj primes maybe-prime)
          (recur (inc maybe-prime))
          )))
(memo-prime (memo-prime [2 3 5]))

(defn faster-prime? [maybe-prime]
  (loop [maybe-factor 2]
      (or (> maybe-factor (Math/sqrt maybe-prime))
          (if-not (= 0 (mod maybe-prime maybe-factor))
              (recur (inc maybe-factor))
              false))))

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
