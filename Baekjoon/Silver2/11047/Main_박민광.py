N, K = map(int, input().split())
M = []
ans = 0

for i in range(N):
    M.append(int(input()))

for j in range(N-1, -1, -1):
    if K == 0:
        break
    if M[j] > K:
        continue
    ans += K // M[j]
    K %= M[j]

print(ans)