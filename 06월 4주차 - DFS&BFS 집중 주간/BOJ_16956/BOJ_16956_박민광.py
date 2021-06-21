import sys

R,C = map(int, sys.stdin.readline().split())

area = [list(sys.stdin.readline().rstrip()) for _ in range(R)]

dx, dy = [0,1,0,-1],[1,0,-1,0]

ck = False

for i in range(R):
    for j in range(C):
        if area[i][j] == 'W':
            for w in range(4):
                di, dj = i + dx[w], j + dy[w]
                if di < 0 or di == R or dj < 0 or dj == C:
                    continue
                if area[di][dj] == 'S':
                    ck = True
if ck :
    print(0)
else:
    print(1)
    for i in range(R):
        for j in range(C):
            if area[i][j] not in 'SW':
                area[i][j] = 'D'

for i in area:
    print(''.join(i))

