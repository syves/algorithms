var R = require('ramda');

var quicksort = R.ifElse(
  R.isEmpty,
  R.identity,
  function(xs) {
    var head = R.head(xs);
    var tail = R.tail(xs);
    var pair = R.map(quicksort, R.partition(R.lt(R.__, head), tail));
    return R.foldl(R.concat, [], R.insert(1, [head], pair));
  }
);


console.log(quicksort([3, 4, 3, 2, 1, 6, 5, 3]));
