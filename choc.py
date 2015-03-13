def num_choc(dollars, cost, wrappers_required, wrappers):
    if dollars >= cost:
        print "dollars >= cost: dollars: {}".format(dollars)
        print "dollars >= cost: wrappers: {}".format(wrappers)
        return (1 + num_choc(dollars - cost, cost, wrappers_required, wrappers + 1))
    elif wrappers >= wrappers_required:
        print "wrappers >= wrappers_required: dollars {}".format(dollars)
        print 'wrappers >= wrappers_required: wrappers {}'.format(wrappers)
        return 1 + (wrappers - wrappers_required) + num_choc(dollars, cost, wrappers_required, wrappers - wrappers_required)
    else: #wrappers < wrappers required
        print dollars
        print wrappers
        return 0

print num_choc(10, 2, 5,0) #6 #6
print num_choc(12, 4, 4, 0) #3 #3
print num_choc(6, 2 ,2, 0)   #5 #4
'''
# ::main //string=>string
def main():
    T = int(raw_input())
    
    #[(x, y) for x in [1,2,3] for y in [3,1,4] if x != y] #make pairs...not what we want
    #HOw to ASSign ?  dollars, cost, wrappers_required
    #tests = [[dollars, cost, wrappers_required] for i in range(0, T) for
    #dollars, cost, wrappers_required = map(int, raw_input().split(' '))]
    
    xs = [map(int, raw_input().split(' ')) for i in range(0, T)]       #string::[[int]]
    for x in xs:
        dollars = x[0]
        cost = x[1]
        wrappers_required = x[2]
    wrappers = 0
    
    #print xs #[[10, 2, 5], [12, 4, 4], [6, 2, 2]]
    return str(num_choc(dollars, cost, wrappers_required, wrappers))

for i in (sys.stdin):
    sys.stdout.write(str(main()) + '\n')

#if __name__ == '__main__':
#    main()
'''



