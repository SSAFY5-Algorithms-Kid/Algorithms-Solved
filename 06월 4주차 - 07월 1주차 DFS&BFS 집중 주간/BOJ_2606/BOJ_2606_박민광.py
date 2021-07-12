from collections import deque

n = int(input())
p = int(input())
M = [[0]*(n+1) for i in range(n+1)]
visit = [0 for _ in range(n+1)]
for i in range(p):
    a,b = map(int, input().split())
    M[a][b] = 1
    M[b][a] = 1

q = deque([1])
visit[1] = 1
cnt = 0
while q:
    x = q.popleft();
    for i in range(n+1):
        if M[x][i] == 1 and visit[i]!=1:
            cnt += 1
            visit[i]=1
            q.append(i)
print(cnt)






