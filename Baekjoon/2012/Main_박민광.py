from sys import stdin

N = int(stdin.readline().rstrip())

temp = list()

for i in range(N):
    temp.append(int(stdin.readline().rstrip()))

temp.sort()

ans = 0

for i in range(N):
    ans = ans + (abs((i+1) - temp[i]))

print(ans)


