import sys
from collections import deque

N = int(input())
A,B = map(int, sys.stdin.readline().split())
M = int(input())

def bfs(start, target):
    cnt = 0
    dq = deque([[start,cnt]])
    while dq:
        tmp = dq.popleft()
        node = tmp[0]
        cnt = tmp[1]
        if node == target:
            return cnt
        if not visited[node]:
            cnt += 1
            visited[node] = True
            for i in chon[node]:
                if not visited[i]:
                    dq.append([i,cnt])
    return -1

chon = [[] for _ in range(N+1)]
visited = [False] * (N+1)
for _ in range(M):
    x,y = map(int, sys.stdin.readline().split())
    chon[x].append(y)
    chon[y].append(x)

print(bfs(A,B))


