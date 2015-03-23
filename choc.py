# ::num_choc //[int], int=>int
def num_choc(dollars, cost, wrappers_required, wrappers):
    choc_allowance = dollars/cost
    choc = choc_allowance
    wrappers += choc_allowance 
    dollars -= choc_allowance * cost
    
    while wrappers >= wrappers_required: 
        new_choc = wrappers / wrappers_required
        wrappers %= wrappers_required
        choc += new_choc
        wrappers += new_choc
    return choc
    
def main():
    T = int(raw_input())
    triplets = [map(int, raw_input().split(' ')) for i in range(0, T)]
    print '\n'.join([str(num_choc(dollars, cost, wrappers_required, 0))
                     for dollars, cost, wrappers_required in triplets])

if __name__ == '__main__':
    main()
