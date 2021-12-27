import sys

N = int(sys.stdin.readline().rstrip())

person = list(map(int, sys.stdin.readline().rstrip().split(' ')))

person.sort()
ans = 0

for i in range(N):
    for j in range(i+1):
        ans = ans + person[j]

print(ans)