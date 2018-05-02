(ns euler_problem_10)
  ;(:require [clojure.math.numeric-tower :as math]))

;The sum of the primes below n. is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of primes below two million).

; Int -> List Numer ; could try using pre and post conditions
;(defn factors [num] (map (partial / num) (range 1 (inc num))))

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

;Int -> Boolean
(defn prime? [num]
             (if (= num 1)
                 false
                 (empty? (remove #{num 1} (filter integer? (factors num))))))

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

;TODO how to make sumprimes lazy.. call next prime indef and then take of num-primes
(defn natural-nums  [n] (lazy-seq (cons n (natural-nums (inc n)))))

; Int -> Int -> List Double
;why cant I access Math/pow when it is inside partial and map?
(defn n-multiples [num-multiples num]
  (map
      (partial ((memfn Math/pow) (double num)))
      (range 2.0 (inc num-multiples)) ))
(n-multiples 2 3)

(defn primes-with-memo [num]
  (println (count (keys prime-multiples)))
  (loop [num-primes num sum 0 curr-prime 2 prime-multiples {}]
    (let multiples []

    (prime-multiples assoc curr-prime))
    (if (zero? num-primes)
        sum
        (recur (dec num-primes) (+ sum curr-prime) (next-prime curr-prime)))))


(sum-primes 4)
(sum-primes 5)
(sum-primes 1000)
;(sum-primes 10000); around 2 minutes
;(sum-primes 2000000)


;do prime numbers have a real root?
