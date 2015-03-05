function editCount(_string) {
  var edit_count = 0;
  //for each char in string
  for(var x = 0; x < _string.length; x ++) {
    //console.log(_string[x]);
    //console.log('x: '+ _string[x] + " x+1: " + _string[x+1]);
    
    //compare elem of string to its neighbor
    if(_string[x] == _string[x+1]) {
      edit_count += 1;
    }
    //console.log(edit_count)
  }
  return edit_count
}
//console.log(editCount('AABB'))
//console.log(processData(['AAAA', 'BBBBB', 'ABABABAB', 'BABABA', 'AAABBB']))

function main(input){
  results = [];
  //for each elem in input, call editCount
  for(var elem = 0; elem < input.length; elem ++){
    //console.log(input[elem]);
    //console.log(editCount(input[elem])); //why 0 not undefined?
    results.push(editCount(input[elem]))
  }
  return results
}

console.log(main(['AAAA', 'BBBBB', 'ABABABAB', 'BABABA', 'AAABBB'])) //stand.in
