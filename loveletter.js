function getCharCode(chr){
   return chr.charCodeAt(0)//? idx
}

function sum(a,b){return a + b}

function makePair(s){
  // s = 'xxxxx'
  // => ['x', 'x', 'x'] => [64, 66, 37]
  charCodes = s.split('').map(getCharCode)
  var numPairs = Math.floor(s.length / 2)
  pairs = []

  for (var offset = 0; offset <= numPairs; offset++){
    
    pairs.push([charCodes[offset], charCodes[charCodes.length -1 - offset]])
  }
  //console.log(pairs)
  //for each pair
  return pairs.map(function(pair){
    //console.log(Math.abs(pair[0] - pair[1]))
    return Math.abs(pair[0] - pair[1])
  }).reduce(sum, 0)
}
//console.log(makePair('abcdb'))

function main(input){ //takes in a string and returns a string
  return input.split('\n').slice(1).map(makePair).map(String).join('\n')
  }
console.log(main('5/n\abc\nabcba\nabcd\ncba'));

