import sys
from collections import deque
sys.setrecursionlimit(10**6)

def dfs(V):
    visit[V] = 1
    dfs_result.append(V)
    for i in board[V]:
        if visit[i] == 0:
            visit[i] = 1
            print(i)
            dfs(i)


def bfs(V):
    visit = [0] * (N + 1)
    visit[V] = 1
    bfs_result.append(V)
    tmp = deque()
    tmp.append(V)
    while tmp:
        V = tmp.popleft()
        for i in board[V]:
            if visit[i] == 0: # visit 처리를 리스트 append로 visit안에 값이 있는가를 검색하게했었는데, 다이렉트로 인덱스의 값이 0인지를 비교하는 것이 효율적
                bfs_result.append(i)
                tmp.append(i)
                visit[i] = 1


N, M, V = map(int, sys.stdin.readline().split())
board = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    board[a].append(b)
    board[b].append(a)
for i in range(len(board)):
    board[i].sort()
print(board)
visit = [0] * (N + 1)
dfs_result = []
bfs_result = []
dfs(V)
bfs(V)
print(*dfs_result)
print(*bfs_result)