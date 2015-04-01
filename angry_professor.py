#::is_canceled //[int]->string
def is_canceled(K, nums):
    on_time = [n for n in nums if n <= 0]
    return "YES" if len(on_time) < K else "NO"

#::main //string->string
def main():
    T = int(raw_input())
    for i in range(0, T):
        N, K = map(int, raw_input().split(' '))
        print is_canceled(K, map(int, raw_input().split(' ')))

if __name__ == '__main__':
    main()
