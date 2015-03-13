// group :: [Number],Number -> [[Number]]
function group(xs, k) {
  var chunks = [];
  for (var n = 0; n <= xs.length - k; n++) {
    chunks.push(xs.slice(n, n + k));
  }
  return chunks;
}

// diff :: [[Number]] -> Number
function diff(chunks) {
  var min = Infinity;
  for (var idx = 0, len = chunks.length; idx < len; idx += 1) {
    var chunk = chunks[idx];
    var delta = chunk[chunk.length - 1] - chunk[0];
    if (delta < min) { min = delta; }
  }
  return min;
}

// processData :: String -> String
function processData(input) {
  var xs = input.split('\n').map(Number);
  var n = xs[0];
  var k = xs[1];
  var chunks = group(xs.slice(2, 2 + n)
                       .sort(function(a, b) { return a - b; }),
                     k);
  return String(diff(chunks))           // [[int]] -> [string]
}

var input = '';
process.stdin.resume();
process.stdin.on('data', function(data) { input += data; });
process.stdin.on('end', function() {
  process.stdout.write(processData(input) + '\n');
});

