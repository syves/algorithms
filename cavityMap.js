var rows = [ '1112', '1912', '1892', '1234' ].map(function(x){
  return x.split('').map(Number)
})

console.log(rows)

var bigString = [ '1112', '1912', '1892', '1234' ].join('')
console.log(bigString)
  //for row in rows? 
  //
  //if cell is not on edge

  bigString.map(function(x){ 
    var not_first_or_last_row = []
    if (bigString[x] > bigString.length4 and < bigString.length[x] - 4){
        
    }
  })

//once we find an element that is not an edge
//find that elements adjacent cells
//  rows[y][x - 1]
//  xs[i +1], 
//  xs[i -n -1],
//  xs[i +n +1]
//
//[ [ 1, 1, 1, 2 ], 
//[ 1, 9, 1, 2 ],
// [ 1, 8, 9, 2 ],
//  [ 1, 2, 3, 4 ] ]
//rows[0][x-1
//
