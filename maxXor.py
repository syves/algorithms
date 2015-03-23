#   getPairs :: [int] -> [(int, int)]
'''
def getPairs(xs):
    if len(xs) <= 1:
        return []
    else:
        return [(xs[0], xs[n]) for n in range(0, len(xs))] + getPairs(xs[1:])
'''
def getPairs(xs):
    pairs = []
    #head = xs[n]
    #rest = xs[n+1:len(xs)]
    for n in range(0, len(xs)-1):
        pairs.append([xs[n], xs[n]])
        pairs.append([xs[n], xs[n+1]])
    return pairs

#   maxXor :: int, int -> int
def maxXor(l, r):
    return max([a ^ b for a, b in getPairs(range(l, r + 1))])

def main():
    l = int(raw_input());
    r = int(raw_input());

    return "{}".format(maxXor(l, r))

print main();
