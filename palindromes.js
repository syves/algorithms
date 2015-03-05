function decrementChar(char){
  //decrement char
  var dec = char.charCodeAt(0)-1
  //get the string value of new char
  return String.fromCharCode(dec)
}

//string => Pair: leftChar, rightChar ='a', 'b'] 'abcd'
function makePairs(s){
  //find the middle => 'abcd'  //even numbered string
  if (s.length % 2 === 0){ 
    console.log('in even');
      //is an index
    middle = s.length / 2 - 1
    left = s.slice(0, s[s.length / 2 - 1])
    right = s.slice(s[s.length / 2 + 1], -1)
    //.split().reverse().join()
  } else {
    console.log('in odd');
    middle = s[Math.floor((s.length / 2) + 1)]
    left = s.slice(0, s[s.length / 2 - 2])
    right = s.slice(s[s.length / 2 + 1], s[s.length -1])
    //.split().reverse().join()
    console.log(right)
  }
  console.log('left: ' + left + ' right: ' + right)
   //.map(
  // [left[idx], right[idx]])
}
 
console.log(makePairs('abc', 'bbe'))




/*


 
      if (left != right){
        //how do we know which char to decrement?
        //abcaa vs aacba
        if (left > right){
          decrementChar(left);
        }else{
          decrementChar(left);
         }
      decrements += 1;
      }
    //  if (string[0: middle] === string[string.length - 1:] ){
  //}
    }else{
      middle = string[Math.ceil((string.length / 2) + 1)] 
    }
  return decrements
  }


}
//Think about control flow first

//
//
function main(strings){ //takes in a string and returns a string
   var decrements = 0;
  //check if its is a palindrome already!
  if (string === string.split('').reverse().join('')){
    return decrements;
  } else {
  .....
  }
  //.join('\n') + ''
}

main('abc\nabcba\nabcd\ncba');
*/
