function flip(bitNum){
  //00000000000000000000000000000001 => 11111111111111111111111111111110
  var result = '';
  for (var n = 0; n < bitNum.length; n++){
      if (bitNum[n] === '0'){
        result += 1;
      } else {
        result += 0;
      }
  }
  return result;
};

//console.log(flip('00000000000000000000000000000001'))
//
 function ToUint32(x) {
   console.log('x: ' + x)
    var UI32 = x << 32 >>> 0;         //int => UI32 => 2147483648
    console.log('UI32: ' + UI32);
    var bits = UI32.toString(2);      // UI32 => bitnum => 00011111
    console.log('bit: ' + bits);
    var newBit = (flip(bits))          // bitnum => bitnum =>00011111 => 11100000
    console.log('newbit: ' + newBit)
    var result = parseInt(newBit, 10)  // bitnum => uI32 OR int
    console.log(result)
 }
console.log(ToUint32('2147483647'))
console.log(ToUint32('1'))
console.log(ToUint32('0'))



