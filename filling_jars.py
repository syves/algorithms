# :: av [[string]] => int
def av(xs, n):
    strs =  map(lambda x: x[0].split(' '), xs)                      # string::[string]
    nums =  map( lambda y: map(lambda z: int(z), y), strs)          # string::[[int]]
    candies =  map( lambda j: ((j[1] + 1) - j[0]) * j[2], nums )    # [[nums]]::int
    return sum(candies)/n

# :: main  string=>string
def main():
    line_1 = raw_input().split(' ')                  # string::[string]
    n = int(line_1[0])                               # string::int
    m = int(line_1[1])                               # string::int 
    opps = []
    #refactor? get all the following lines of input
    for num in range(0, m):
        opps.append(raw_input().split('/n'))         # [string]  
    return str(av(opps, n))

print main()
