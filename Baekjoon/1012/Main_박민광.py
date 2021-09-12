import sys
from collections import deque

T = int(input())
dx, dy = [0,1,0,-1],[1,0,-1,0]

def bfs(x,y):
    dq = deque()
    dq.append([x,y])
    while dq:
        b, a = dq[0][0], dq[0][1]
        dq.popleft()
        for w in range(4):
            di, dj = a + dx[w], b + dy[w]
            if di < 0 or di == M or dj < 0 or dj == N:
                continue
            if graph[dj][di] == 1:
                graph[dj][di] = 0
                dq.append([dj,di])

for _ in range(T):
    cnt = 0
    M, N, K = map(int, sys.stdin.readline().split())

    graph = [[0]*M for _ in range(N)]

    for _ in range(K):
        a, b = map(int, sys.stdin.readline().split())
        graph[b][a] = 1

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                bfs(i,j)
                graph[i][j] = 0
                cnt += 1

    print(cnt)