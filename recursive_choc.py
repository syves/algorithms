# ::num_choc //[int], int=>int
def num_choc(dollars, cost, wrappers_required, wrappers):
    if dollars >= cost:
        return (1 + num_choc(dollars - cost, cost, wrappers_required, wrappers + 1))
    elif wrappers >= wrappers_required:
        return 1 + (wrappers - wrappers_required) + num_choc(dollars, cost, wrappers_required, wrappers - wrappers_required)
    else: #wrappers < wrappers required
        return 0

def main():
    T = int(raw_input())
    triplets = [map(int, raw_input().split(' ')) for i in range(0, T)]       
    print '\n'.join([str(num_choc(dollars, cost, wrappers_required, 0))
                     for dollars, cost, wrappers_required in triplets])

if __name__ == '__main__':
    main()



