"use strict";
const R = require('ramda');
const S = require('sanctuary');

//    rotations: Array a -> Array (Array a)
const rotations = xs =>
  xs.map((x, idx) => xs.slice(idx).concat(xs.slice(0, idx)));

//    f : Number -> Array Number
const f = S.pipe ([String,
                   S.splitOn (''),
                   rotations,
                   S.map (S.joinWith ('')),
                   S.map (Number)]);

//    isPrime : Number -> Boolean
const isPrime = num => R.none (candidate => num % candidate == 0)
                              (S.range (2) (Math.floor(Math.sqrt(num)) + 1));

//    circlePrimes : Number -> Boolean
const circlePrimes = S.compose (R.all (isPrime)) (f);

console.log(circlePrimes(1193))// = [1931, 9311, 3119, 1193]
console.log(circlePrimes(123))
