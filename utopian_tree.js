'use strict';

//  utopianTree :: Number -> Number
var utopianTree = function(n) {
  // n is number or seasons since tree was planted
  var height = 1;
  for (var m = 1; m <= n; m += 1) {
    if (m % 2 === 1) {
      height *= 2;
    } else {
      height += 1;
    }
  }
  return height;
};

//  processData :: String -> String
var processData = function(input) {
  var lines = input.split('\n');
  var numLines = Number(lines[0]);

  return lines              // :: [String]
    .slice(1, 1 + numLines) // :: [String]
    .map(Number)            // :: [Number]
    .map(utopianTree)       // :: [Number]
    .map(String)            // :: [String]
    .join('\n');            // :: String
};

var input = '';
process.stdin.resume();
process.stdin.on('data', function(chunk) { input += chunk; });
process.stdin.on('end', function() { console.log(processData(input)); });
