(ns "euler_problem_10")
(require '[clojure.math.numeric-tower :as math])

;The sum of the primes below n. is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of primes below two million).

; Int -> List Numer ; could try using pre and post conditions
(defn factors [num] (map (partial / num) (range 1 (inc num))))

(defn faster-prime? [mp]
  (empty?
  (loop [maybe-prime mp maybe-factor 2 factors []]
    ;(println maybe-prime maybe-factor)
    (if (= false (empty? factors))
      factors
      (if (< maybe-factor (dec maybe-prime))
        (recur maybe-prime
               (inc maybe-factor)
               (if (= 0 (mod maybe-prime maybe-factor))
                         (cons maybe-factor factors)
                         factors))
        factors)))))

(lazy-factor 17) ; true
(lazy-factor 18) ;false

;cons n (lazy-seq (/ maybe-prime (inc maybe-factor)

;Int -> Boolean
(defn prime? [num]
             (if (= num 1)
                 false
                 (empty? (remove #{num 1} (filter integer? (factors num))))))

;TODO: could rewrite n-primes to create a lazy sequence

(defn next-prime
  [num]
  (loop [numbr num]
    (let [maybe-prime (inc numbr)]
      (if (faster-prime? maybe-prime)
          maybe-prime
          (recur maybe-prime)))))

;find all the primes below 2 million
;Int -> Int
(defn sum-primes
  [num]
  (loop [num-primes num sum 0 curr-prime 2]
    (if (zero? num-primes)
        sum
        (recur (dec num-primes) (+ sum curr-prime) (next-prime curr-prime)))))
  ;(reduce + (filter prime? (range 1 (inc num)))))

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
(sum-primes 10000); around 2 minutes

;maybe we should store each prime in a map. and exclude all mutiple of that prime from checking?
;we would not need to factor it or filter it.
;are most numbers divisable by 2, 3, 5, 7, 11, 13,
;maybe get exponentsup to 10? are they the same as multiples?
;..maybe we want filter before checking if something is prime.
; if it in dictionary? it is a multiple of a prime we have already found
;is it divisable by a larger even number than it is divied by 2,
;[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17...54]
;do prime numbers have a real root?


;(sum-primes 2000000)
