(ns n-primes)
;find n primes

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

(defn n-primes [num]
  (loop [prime 0 num-primes num primes []]
    (if (zero? num-primes)
        primes
        (recur (next-prime prime)(dec num-primes)(conj primes (next-prime prime))))))


(n-primes 10)
(n-primes 1000)
(n-primes 10000) ;104729 slow!

;bench marks?
