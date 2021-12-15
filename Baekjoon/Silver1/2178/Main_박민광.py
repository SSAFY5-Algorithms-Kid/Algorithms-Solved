def bfs(x, y):
    queue = [(x, y)]
    while queue:
        x, y = queue.pop(0)

        if x == M-1 and y == N-1:
            print(dist[x][y])
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N:
                if board[nx][ny] == '1' and dist[nx][ny] == 0:
                    queue.append((nx, ny))
                    dist[nx][ny] = dist[x][y] + 1

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

M, N = map(int, input().split())
board = [list(input()) for _ in range(M)]
dist = [[0]*N for _ in range(M)]

dist[0][0] = 1
bfs(0,0)

