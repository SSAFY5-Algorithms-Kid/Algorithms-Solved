from sys import stdin

N = int(stdin.readline().rstrip())
R = list()

for i in range(N):
    R.append(list(map(int,stdin.readline().rstrip().split(' '))))

R = sorted(R, key=lambda a:a[0])
R = sorted(R, key=lambda a:a[1])

ans = 0
end = 0

for i,j in R:
    if i >= end:
        ans += 1
        end = j
print(ans)