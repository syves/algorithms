function counts(s){
  c = {};
  for (var x = 0; x < s.length; x++){
    if (c[s[x]]) {
      c[s[x]] += 1;
    } else {
      c[s[x]] = 1;
    }
  }
  return c
}

function couldBePal(dict){
  var oddCounts = 0;
  for (var index in dict){
    if (dict[index] % 2 != 0){
      oddCounts += 1;
    }
  }
  return String(oddCounts <= 1).toUpperCase(); //true is Pal, > 1 , false
}

console.log(couldBePal(counts('cdcdcdcdeeeef')))
console.log(couldBePal(counts('cdefghmnopqrstuvw')))
