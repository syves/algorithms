(ns "euler-problem-10")

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


(sum-primes 4)
(sum-primes 5)
;I haven't yet thought of a way to make this efficient for large numbers
;(sum-primes 2000000)
