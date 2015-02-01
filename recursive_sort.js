var recur_sort = function(array){
  if (array.length === 0){
    return [];
  } else {
    var left = [];
    var right = [];
    var pivot = array[0]
    array.slice(1).forEach(function(x){
      if (x <= pivot){
        left.push(x)
      } else {
        right.push(x)
      }
    })
   return [].concat(recur_sort(left), [pivot], recur_sort(right))
   }
}

console.log(recur_sort([4,7,9,5,3,2,8]))
