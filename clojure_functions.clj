;;A Clojure sandbox

(rest [66 55 67])
(count [33 55])
(vector? [44 33])

(defn total-bill
 "Given subtotal of bill, return total aftet tax"
 [subtotal] ; this is the input
 (* 1.08 subtotal))

 (defn total-with-tip
 "Given subtotal, returns total with tax and tip"
 [subtotal tip-pct]
 (* 1.08 subtotal (+ 1 tip-pct)))

(total-with-tip 12.50 0.18)
(total-with-tip 50 0.18)

(defn share-per-person
"Given subtotal returns share per person"
[subtotal tip-pct num-people]
(/ (* 1.08 subtotal (+ 1 tip-pct)) num-people))

(share-per-person 67 0.15 2)

(def dine-in-orders [12.50 20 21 16 18.40])
(def take-out-orders [6.60 6.00 7.95 6.25])

(map total-bill dine-in-orders)
(map total-bill take-out-orders)

(+ 2 3)
(println "hello world")
(max 8 7 28)
(+ 6 8 35)
(/ 2 4)
1/2
'Proust'
"proust"
(def mangoes 3)
(def oranges 5)
(+ mangoes oranges)
(def feet 5)
(def inches 2)
(def height (+ (* feet 12) inches))
(def shakrah (* height 2.4))
(def kristin 157.48)
(def average (/ (+ kristin shakrah) 2))
(def feet (quot (/ average 2.54) 12))
(def inches (mod (/ average 2.54) 12))
(map #(str "" % "") ["the" "quick" "brown" "fox"])
["a", "b", "c", "d", "e", "f"]

(vector? [ 5 10  15])
;;(vector 5 10 15)
(conj [5 110 4] 5 8 )
(defn total-with-tip
  [subtotal tip-pct] ;;takes two args

  (* 1.085 subtotal (+ 1 tip-pct)))
(total-with-tip 50 0.18) ;;call with args

(defn shar-per-person
  [subtotal tip-pct num-people]
  ( / (* 1.085 subtotal (+ 1 tip-pct)) num-people)

  )
(shar-per-person 50 0.18 5)

(def dine-in-orders [12.4, 18.95, 23.81, 19.95, 12.40])
(def take-out-orders [6.0 6.0 7.95 6.25])

(map total-bill dine-in-orders)
(map total-bill take-out-orders)
(defn add
  [x y]
  (+ x y))
(def take-out-totals [6.51 6.51 8.62575 6.78125])

(reduce add take-out-totals)
(add 6.51 6.51)
(add 13.02 8.62575)
(add 21.64575 6.78125)

(defn average
  [totals]
  (/  (reduce add totals) (count totals))
  )
(average [62.5, 83.90, 26.40])

"hello world"
"This is a longer string that I wrote for purposes of an example"
;;"Aubry said, "\I think we should got to the "Oramge Julious."
(def my-hometown "SF");;

(defn join-with-space
  [string1 string2]
  (str string1 " " string2))

(reduce join-with-space ["shakrah" "yves"])
(reduce join-with-space ["blah" "meow" "woof"])
(+ 2 1)
(+ 2 2)

{:x "y"};;map
{:first-name "shakrah" :last-name "yves"}
(defn format-name
  [person]
  (join-with-space (:first-name person)
                   (:last-name person)))

(format-name {:first-name "shakrah" :last-name "yves"})

(map? {:first "Sally" :last "Brown"})
(get {:first "Sally" :last "Brown"} :first)
(get {:first "Sally"} :last :MISS)
(assoc {:first "Sally" :last "Brown"} :last "Brown");;set last name to brown
(dissoc {:first "Sally" :last "Brown"} :last "Brown");; does not return last
(merge {:first "Sally"} {:last "Brown"})
(count {:first "Sally" :last "Brown"})
(keys {:first "Sally" :last "Brown"})
(vals {:first "Sally" :last "Brown"})
(into {} [[1 2] [3 4]])
(:first {:first "Sally" :last "Brown"})
(:last {:first "Sally" :last "Brown"})
(:last {:first "Sally"})

(def me {:first-name "shakrah" :last-name "yves"})
(def new-me (assoc me :hometown "sf"))
(vals new-me)

(def people [{:first "margaret" :last "atwood"}
            {:first "Doris" :last "Harland"}])

(defn get-first-names [people]
  (map :first people))

(get-first-names people)


(def people [{:first "Margaret" "Atwood"}
             {:first "Doris" :last "Lessing"}
             {:first "Ursula" :last "Le Guin"}
             {:first "Alice" :last "Munro"}])

(defn get-full-name [people]
  (str (:first people) " " (:last people)))
 (get-full-name {:first  :laist})

;vector of high temperatures for this week
(vector 66 66 63 63 61)
(nth [66 66 63 63 61] 0)
(first [66 66 63])
(rest [66 55 67])
(count [33 55])
(vector? [44 33])
(defn total-bill
 "Given subtotal of bill, return total aftet tax"
 [subtotal] ; this is the input
 (* 1.08 subtotal))

 (defn total-with-tip
 "Given subtotal, returns total with tax and tip"
 [subtotal tip-pct]
 (* 1.08 subtotal (+ 1 tip-pct)))

(total-with-tip 12.50 0.18)
(total-with-tip 50 0.18)

(defn share-per-person
"Given subtotal returns share per person"
[subtotal tip-pct num-people]
(/ (* 1.08 subtotal (+ 1 tip-pct)) num-people))

(share-per-person 67 0.15 2)

(def dine-in-orders [12.50 20 21 16 18.40])
(def take-out-orders [6.60 6.00 7.95 6.25])

(map total-bill dine-in-orders)
(map total-bill take-out-orders)

(defn add
  [x y]
  (+ x y))

(reduce add [1 2 3])

(def take-out-totals [6.48 6.48 8.586 6.75])
(reduce add take-out-totals)

(defn average
  "returns an average of bill amounts"
  [take-out-totals]
  (/ (reduce add take-out-totals) (count take-out-totals)))

(average take-out-totals)
(def my-home-town "san francisco")

(defn format-name
  "formats a name, returns a single string"
  [first-name last-name]
  (str last-name ", " first-name)
)

(format-name "Shakrah" "Yves")

(defn meaning-of-life?
  [x]
  (= x 42))

(> 4 3)
(>= 4 5)
(<= -1 -2)

(str "shakrah" "yves")

(map (fn [x] (* 3 x)) [1 2 3])
(reduce (fn [x y] (+ x y)) [1 2 3]);takes a function and a vectorto map over
(reduce (fn [s1 s2] (str s1 " " s2)) ["i" "like" "peanut" "butter" "and" "jelly"])

{:first "shakrah" :last "yves"}
{:age 31 :hieght 5.52}

(def name {:first "Shakrah" :last "Yves"})
(get name :first)
(map? name)

(assoc name :middle "Lilly")
(dissoc name :middle)

(merge {:name "David"} {:nick-name "Panda"})
(keys name)
(vals name)
(:first name)
(:middle name)

(def names [{:name "David"} {:nick-name "Panda"}])
(first names)

(def bio (merge name {:hometown "San Francisco"}))

(def name-vector [{:first "Margaret" :last "Atwood"}
            {:first "Doris" :last "Lessing"}
            {:first "Ursula" :last "Le Guin"}
            {:first "Alice" :last "Munro"}])

(defn get-name-hash
  [map]
  (str (get map :first) " " (get map :last)))
(get-name-hash {:first "Doris" :last "Lessing"})



(defn get-names
  "takes a vector of maps and returns a vector of names"
  [name-vector]
  (map get-name-hash name-vector))

(get-names name-vector)


(defn format-names
 "Given strings concats them"
 [map]
 )

