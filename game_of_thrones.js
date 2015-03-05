//  counts :: String -> Object
//
//  > counts('foobar')
//  {a: 1, b: 1, f: 1, o: 2, r: 1}
var counts = function(s) {
  c = {};
  for (var idx = 0; idx < s.length; idx += 1) {
    if (c[s[idx]]) {
      c[s[idx]] += 1;
    } else {
      c[s[idx]] = 1;
    }
  }
  return c;
};

//  couldBePal :: Object -> Boolean
//
//  > couldBePal({a: 1, b: 1, f: 1, o: 2, r: 1})
//  false
var couldBePal = function(dict) {
  var oddCounts = 0;
  for (var letter in dict) {
    if (dict[letter] % 2 != 0) {
      oddCounts += 1;
    }
  }
  return oddCounts <= 1;
};

//  formatBoolean :: Boolean -> String
//
//  > formatBoolean(false)
//  'NO'
var formatBoolean = function(b) {
  return b ? 'YES' : 'NO';
};

//  processData :: String -> String
var processData = function(input) {
  return formatBoolean(couldBePal(counts(input.trim())));
};

process.stdin.resume();
var input = '';
process.stdin.on('data', function(chunk) { input += chunk; });
process.stdin.on('end', function() { console.log(processData(input)); });
