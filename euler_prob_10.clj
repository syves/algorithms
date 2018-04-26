(ns "euler_problem_10")
(require '[clojure.math.numeric-tower :as math])

;The sum of the primes below n. is 2 + 3 + 5 + 7 = 17.
;1. Find the sum of primes below two million).

; Int -> List Numer ; could try using pre and post conditions
(defn factors [num] (map (partial / num) (range 1 (inc num))))

;Int -> Boolean
(defn prime? [num]
             (if (= num 1)
                 false
                 (empty? (remove #{num 1} (filter integer? (factors num))))))

(defn next-prime
  [num]
  (loop [numbr num]
    (let [maybe-prime (inc numbr)]
      (if (prime? maybe-prime)
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
;I haven't yet thought of a way to make this efficient for large numbers.
;800 primes was relatively fast. but 10,000 took longer than 10 minutes,
;it seems the larger the number the less likely it is to be prime,
;so more checking has to be done to capture fewer primes.
;maybe we should store each prime in a map. and exclude all mutiple of that prime from checking?
;we would not need to factor it or filter it.
;are most numbers divisable by 2, 3, 5, 7, 11, 13,
;maybe get exponentsup to 10? are they the same as multiples?
;..maybe we want filter before checking if something is prime.
; if it in dictionary? it is a multiple of a prime we have already found
;is it divisable by a larger even number than it is divied by 2,
;[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17...54]


;(sum-primes 2000000)
