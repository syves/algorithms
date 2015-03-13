
// diff :: [[Number]],Number -> Number
function diff(nums, k) {
  var min = Infinity;
  var b = nums[idx];
  var a = nums[idx - (k - 1)]

  for (var idx = nums.length -1; idx >= k -1; idx -= 1) {
    var b = nums[idx];
    var a = nums[idx - (k - 1)]
    var delta = b - a;
    if (delta < min) { min = delta; }
  }
  return min;
}

// processData :: String -> String
function processData(input) {
  var xs = input.split('\n').map(Number);
  var n = xs[0];
  var k = xs[1];
  var nums = xs.slice(2, 2 + n)
                       .sort(function(a, b) { return a - b; });

  return String(diff(nums, k))           // [[int]] -> [string]
}

var input = '';
process.stdin.resume();
process.stdin.on('data', function(data) { input += data; });
process.stdin.on('end', function() {
  process.stdout.write(processData(input) + '\n');
});
