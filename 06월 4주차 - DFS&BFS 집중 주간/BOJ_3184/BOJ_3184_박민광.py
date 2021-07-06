dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


def bfs(x, y):
    queue = [(x, y)]
    o, v = 0, 0
    while queue:
        x, y = queue.pop()
        if board[x][y] == 'v':
            v += 1
        if board[x][y] == 'k':
            o += 1
        board[x][y] = '#'

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N:
                if board[nx][ny] != '#':
                    queue.append((nx, ny))
    if o <= v:
        o = 0
    else:
        v = 0
    return o, v


M, N = map(int, input().split())
board = [list(input()) for _ in range(M)]
O, V = 0, 0
for i in range(M):
    for j in range(N):
        if board[i][j] == 'v' or board[i][j] == 'o':
            o, v = bfs(i, j)
            O += o
            V += v

print(O, V)
