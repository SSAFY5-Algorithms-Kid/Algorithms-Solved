import sys
from collections import deque

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

N, M = map(int, input().split())
board = [list(sys.stdin.readline().rstrip().split(" ")) for _ in range(M)]
dist = [[0]*N for _ in range(M)]
queue = deque()

for i in range(M):
    for j in range(N):
        if board[i][j] == '1':
            queue.append((i, j, 0))
            dist[i][j] = 1

while queue:
    x, y, cnt = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < M and 0 <= ny < N:
            if board[nx][ny] == '0' and dist[nx][ny] == 0:
                dist[nx][ny] = 1
                queue.append((nx, ny, cnt + 1))

for i in range(M):
    for j in range(N):
        if dist[i][j] == 0 and board[i][j] == '0':
            print(-1)
            sys.exit()
print(cnt)