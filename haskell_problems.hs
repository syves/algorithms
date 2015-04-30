-- basic Haskell functions with notes denoting my understanding,
-- and questions I have about Haskell.

import Data.List
import qualified Data.Map as Map
import qualified Data.Set as Set

doubleMe x = x + x

doubleUs x y = x*2 + y*2

doubleUs22 x y = doubleMe x + doubleMe y

doubleSmallNumber x = if x > 100
                        then x
                        else x*2

doubleSmallNumber' x = (if x > 100 then x else x*2)+1


boomBangs xs = [ if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]

a = [1,2,2]

--pattern matching alternative to branching
lucky :: (Integral a) => a -> String
lucky 7 = "Lucky number seven!"
lucky x = "Sorry you are out of luck pal!"

sayMe :: (Integral a) => a -> String
sayMe 1 = "ONE!"
sayMe 2 = "TWO!"
sayMe 3 = "THree"
sayMe 4 =  "four"
sayMe 5 = "five"
sayMe x = "Not between 1 and 5"

factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial n = n * factorial (n-1)

first :: (a,b,c) -> a
first (x, _, _) = x

second :: (a,b,c) -> b
second (_, y, _) = y

third :: (a,b,c) -> c
third (_, _, z) = z

head' :: [a] -> a
head' [] = error "can't call head on an empty list!"
head' (x:_) = x

tell :: (Show a) => [a]-> String
tell [] = "the list is empty"
tell (x:[]) = "the list has one element" ++ show x
tell (x:y:[]) = "the list has two elements" ++ show x ++ " and " ++ show y
tell (x:y:_) = " the list is long, the first two elements are:" ++ show x ++ " and  " ++ show y

--recurion alternative to looping
length' :: (Num b) => [a] -> b
length' [] = 0
length' (_:xs) = 1 + length' xs

sum' :: (Num a) => [a] -> a
sum' [] = 0
sum' (x:xs) = x + sum' xs

capital :: String -> String
capital "" = "Empty string, whoops!"
capital all@(x:xs) = "the first letter of " ++ all ++ " is " ++ [x]

bmiTell :: (RealFloat a) => a -> a -> String
--guards are alternative to else branching returns bools
bmiTell weight height
    | bmi <= 18.5 = "you are underweight you emo you!"
    | bmi <= 25.5 = "you're supposedly normal"
    | bmi <= 30.0 = "you are fat!"
    | otherwise   = "you are a whale!"
    -- named variables will only be calculated once!
    -- only vivsible in this function, does not pollute namespace
    where bmi = weight / height ^ 2
    -- use where bindings to pattern match
    -- (skinny, normal, fat) = (18.5, 25.5, 30.0)

max' :: (Ord a) => a -> a -> a
max' a b
    | a > b = a
    | otherwise = b

mycompare :: (Ord a) => a -> a -> Ordering
a `mycompare` b
    | a > b     = GT
    | a == b    = EQ
    | otherwise = LT

--what is a binding? an assignment...that lets you bind to a variable
--where bindings let you bind to a var at the end of a function,
--can be accessed anywhere in function
--syntactic constructs

initials :: String -> String -> String
initials firstname lastname = [f] ++ ". " ++  [l] ++ "."
    where (f:_) = firstname
          (l: _) = lastname

calcBmis :: (RealFloat a)=> [(a, a)] -> [a]
calcBmis xs = [bmi w h | (w, h)  <- xs]
-- one can nest where bindings 
    where bmi weight height = weight / height ^ 2

--let bindings allow you to bind anywhere,
-- but are local do not cross gaurds!
-- are expressions

cylinder :: (RealFloat a) => a -> a -> a
cylinder r h =
    let sideArea = 2 * pi * r * h
        topArea = pi * r ^ 2
    in  sideArea + 2 * topArea

calcBmis' :: (RealFloat a) => [(a,a)]-> [a]
-- return list of results of bmi, where bmi is defined inside comprehension
-- and we could include a filtering condition
-- we do not need to use the 'in' part of let binding
--  - because names are clearly visible?
calcBmis' xs = [bmi | (w, h) <- xs, let bmi = w / h ^ 2]

--calcbmis' xs = [bmi | (w, h) <- xs, let bmi = w / h ^2, bmi >= 25.0]

--case expressions
head2' :: [a] -> a
head2' xs = case xs of [] -> error "no head for empty lists!"
                       (x:_) -> x

--pattern matching in functions is syntactic sugar for case expressions
describeList :: [a] -> String
describeList xs = "The list is " ++ what xs
      where what [] = "empty."
            what [x] = "a singleton"
            what xs = " a longer list"

maximum' :: (Ord a) => [a] -> a
maximum' [] = error "maximum of empty list"
maximum' [x] = x
maximum' (x:xs)
    | x > maxTail = x
    | otherwise = maxTail
    where maxTail = maximum' xs

replicate' :: (Num i, Ord i) => i -> a -> [a]
replicate' n x
    | n <= 0  = []
    | otherwise = x:replicate' (n-1) x

--replicate 3 "hi"
--3 /<= 0
-- "hi":[] ..and replicate' (3-1) X
--      "hi":["hi"] ..and replicate' (2-1) x
--                "hi":["hi", "hi"]..and and replicate' (1-1) x
--                   []:["hi", "hi", "hi"]?

--takes x elements from the front of array
--get head x times?
--takes an integer x and an collection that could be ordered?
-- returns a collection

take' :: (Num i, Ord i) => i -> [a] -> [a]
-- case 1
take' n _
    | n <= 0  = []
-- no otherwise , if not met falls thru to case 2
take' _ []    = []
--case 3 recursively get the head
take' n (x:xs) = x : take' (n-1) xs

reverse' :: (Ord a) => [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x]

-- takes an element of some type and returns a collectin 
take 5 repeat 3
replicate 5 3

zip' :: [a] -> [b] -> [(a,b)]
zip' _ [] = []
zip' [] _ = []
--for each head of collection make a pair, call until xs or ys is empty 
zip' (x:xs) (y:ys) = (x,y):zip' xs yz

-- returns true /false not a
elem' :: (Eq a) => a -> [a] -> Bool
elem' a [] = False
elem' a (x:xs)
    | a == x  = True
    | otherwise a `elem` xs

quicksort :: (Ord a) => [a]-> [a]
quicksort [] = []
quicksort (x:xs) =
    x:xs

sum' :: (Num a) => [a] -> a
sum' xs = foldl (\acc x -> acc + x) 0 xs

sum2' :: (Num a) => [a] -> a
sum2' = foldl (+) 5
--starting value passed to fold is the acc or value you are adding to
elem' :: (Eq a) => a -> [a] -> Bool
elem' y ys = foldl (\acc x -> if x == y then True else acc) False ys

--foldl returns a single element -reduce, or a collection
--
--FOLDR!
--foldr returns a collection? 
--the ++ function is much more expensive than :, so we usually use right
--folds when we're building up new lists from a list.
--can also be used to reverse a list
--works on infinite lists
-- ?? how can one foldr from the end? of an infite list?

maximum2' :: (Ord a) => [a] -> a  
maximum2' = foldr1 (\x acc -> if x > acc then x else acc)  
 
reverse' :: [a] -> [a]  
reverse' = foldl (\acc x -> x : acc) []  

product' :: (Num a) => [a] -> a  
product' = foldr1 (*)  

numUniques :: (Eq a) => [a] -> Int
numUniques = length . nub

-- get the last element of a list
myList :: [a] -> a
myList (x:[]) = x
myList (_:xs) = myList xs

reverse' :: [a] -> [a]  
reverse' [] = []  
reverse' (x:xs) = reverse' xs ++ [x]  






