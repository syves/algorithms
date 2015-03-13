# pairs :: [int] -> [(int, int)]
def get_pairs(xs):
    if len(xs) <= 1:
        return []
    else:
        head = xs[0]
        tail = xs[1:]
        return [(head, x) for x in tail] + get_pairs(tail) 

# maximals :: [int] -> str
def maximals(nums):                                                       
    topics = map(lambda pair: '{0:b}'.format(pair[0] | pair[1]).count('1'), get_pairs(nums))
    max_topics = max(topics)
    return '{}\n{}'.format(max_topics, topics.count(max_topics))

# main :: () -> ()
def main():
    n, m = map(int, raw_input().split(' '))                      
    print maximals([int(raw_input(), 2) for i in range(0, n)])

if __name__ == '__main__':
    main()

