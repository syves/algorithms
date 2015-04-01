#   get_directions :: int -> int
def get_directions(cuts):
    x_y_counts = {'Y': 0, 'X': 0}
    choc = 0
    for n in xrange(0, cuts):
        direction = 'Y' if n % 2 == 0 else 'X'
        x_y_counts[direction] += 1
        if direction == 'Y':
            choc += x_y_counts['Y'] - 1
        else:
            choc += x_y_counts['X']
    return choc

#    get_directions2 ::int->int
def get_directions2(cuts):
    x = cuts / 2 #4
    y = cuts - x #9
    return x * y

#::main //string->string
def main():
    T = int(raw_input())
    for i in range(0, T):
        print get_directions2(int(raw_input()))

if __name__ == "__main__":
    main()
