n = int(input())
op = input().split()
c = [False] * 10
mx, mn = "", ""

def possible(i, j, k):
    if k == '<':
        return i < j
    if k == '>':
        return i > j

# 어차피 크기 순서대로 dfs를 돌기 때문에 상관이 없음
def solve(cnt, s):
    global mx, mn
    if cnt == n + 1:
        print(mn, mx)
        if not len(mn):
            mn = s
        else:
            mx = s
        return
    for i in range(10):
        if not c[i]:
            if cnt == 0 or possible(int(s[-1]), i , op[cnt - 1]):
                c[i] = True
                solve(cnt + 1, s + str(i))
                c[i] = False


solve(0, "")
print(mx)
print(mn)