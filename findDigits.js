/get_count //[str]-->[int]
var getCount = function(ns, T) {
  return ns.map(function(n){
    //get count of nums that divide into num with no remainder
    count = 0
    n.split('').map(function(x) {
      if (Number(n) % Number(x) === 0){
        count += 1;
      }
    })
  return count;
  })
}

// processData //string --> string
var processData = function(input) {
    T = input.split('\n')[0]
    ns = input.split('\n').slice(1)    
    return getCount(ns, T).map(String).join('\n')
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   process.stdout.write(processData(_input));
});

