#  possible_values::int,int, int->[int]
def possible_values(N, A, B):
    ns = range(0, N)
    return sorted(list({num_as * A + num_bs * B
                        for num_as, num_bs in zip(ns, sorted(ns, reverse=True))}))
    
def main():
    T = int(raw_input())
    for i in xrange(0, T):
        N = int(raw_input())
        A = int(raw_input())
        B = int(raw_input())
        print ' '.join(map(str, possible_values(N, A, B)))
                  
if __name__ == '__main__':
    main()
