import sys

N = int(sys.stdin.readline().rstrip())
dist = list(map(int, sys.stdin.readline().rstrip().split(' ')))
price = list(map(int, sys.stdin.readline().rstrip().split(' ')))

i = 0
p_start = sys.maxsize
ans = 0

for i in range(len(dist)):
    if p_start > price[i]:
        p_start = price[i]
    ans = ans + (p_start * dist[i])

print(ans)