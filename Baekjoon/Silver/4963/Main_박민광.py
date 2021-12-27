import sys

def bfs(x, y):
    queue = [(x, y)]
    while queue:
        x, y = queue.pop(0)
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if board[nx][ny] == '1' and dist[nx][ny] == 0:
                    dist[nx][ny] = 1
                    queue.append((nx, ny))


dx = [0, 1, 0, -1, 1, -1, 1, -1]
dy = [-1, 0, 1, 0, 1, -1, -1, 1]

while(1):
    N, M = map(int, input().split())

    if N == 0 and M == 0:
        break

    board = [list(sys.stdin.readline().rstrip().split(" ")) for _ in range(M)]
    dist = [[0]*N for _ in range(M)]
    island = 0


    for i in range(M):
        for j in range(N):
            if board[i][j] == '1' and dist[i][j] == 0:
                bfs(i,j)
                island += 1

    print(island)

