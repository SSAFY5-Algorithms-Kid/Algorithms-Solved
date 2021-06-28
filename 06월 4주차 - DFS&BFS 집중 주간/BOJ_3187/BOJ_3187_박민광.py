dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


def bfs(x, y):
    queue = [(x, y)]
    k, v = 0, 0
    while queue:
        x, y = queue.pop()
        if board[x][y] == 'v':
            v += 1
        if board[x][y] == 'k':
            k += 1
        board[x][y] = '#'

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N:
                if board[nx][ny] != '#':
                    queue.append((nx, ny))
    if k <= v:
        k = 0
    else:
        v = 0
    return k, v


M, N = map(int, input().split())
board = [list(input()) for _ in range(M)]
K, V = 0, 0
for i in range(M):
    for j in range(N):
        if board[i][j] == 'v' or board[i][j] == 'k':
            k, v = bfs(i, j)
            K += k
            V += v

print(K, V)
