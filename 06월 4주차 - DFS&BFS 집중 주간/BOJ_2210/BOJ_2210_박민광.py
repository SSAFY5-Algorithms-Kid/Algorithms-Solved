import sys

def dfs(x,y,res):
    if len(res) == 6:
        ans.add(res)
        return
    else:
        for w in range(4):
            di, dj = x + dx[w], y + dy[w]
            if 0<= di <5 and 0 <= dj < 5:
                dfs(di,dj,res + matrix[di][dj])

matrix = [list(sys.stdin.readline().split()) for _ in range(5)]
dx, dy = [0,1,0,-1],[1,0,-1,0]
ans = set()

for i in range(5):
    for j in range(5):
        res = matrix[i][j]
        dfs(i,j,res)

print(len(ans))




