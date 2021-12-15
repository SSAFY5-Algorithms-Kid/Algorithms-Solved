import sys

N = int(sys.stdin.readline().rstrip())

ropes = list()

for i in range(N):
    ropes.append(int(sys.stdin.readline().rstrip()))

ropes.sort()
ans = 0

for i in range(len(ropes)):
    temp = ropes[i] * (len(ropes) - i)
    if temp > ans:
        ans = temp

print(ans)
