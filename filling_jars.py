def av(xs):
    strs =  map(lambda x: x[0].split(' '), xs)
    nums =  map( lambda y: map(lambda z: int(z), y), strs)
    candies =  map( lambda j: ((j[1] + 1) - j[0]) * j[2], nums ) #[200, 400, 200]
    return sum(candies)/5

print av([['1 2 100'], ['2 5 100'], ['3 4 100']])
