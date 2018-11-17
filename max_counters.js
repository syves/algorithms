'use strict';

const R = require ('ramda');
const S = require ('sanctuary');


//    solution :: Integer -> Array Integer -> Array Integer
const solution = n => ops =>
  S.snd (S.reduce (([max, counters]) => op =>
                     1 <= op && op <= n ?
                       S.Pair (counters[op - 1] === max ? max + 1 : max)
                              (R.adjust (R.inc) (op - 1) (counters)) :
                       S.Pair (max)
                              (R.repeat (max) (n)))
                  (S.Pair (0) (R.repeat (0) (n)))
                  (ops));

console.log (solution2 (5) ([3,4,4,6,1,4,4]));
