from sys import stdin

N = int(stdin.readline().rstrip())
lank = list(map(int, stdin.readline().rstrip().split(' ')))
ans = 0

while(len(lank)!=1):
    i = lank.index(max(lank))
    temp = 0
    if (1<=i<len(lank) - 1 and lank[i] - lank[i-1] >= lank[i] - lank[i+1]) or i == 0:
        temp = lank[i] - lank[i + 1]
    elif (1<=i<len(lank) - 1 and lank[i] - lank[i-1] < lank[i] - lank[i+1]) or i == len(lank) - 1:
        temp = lank[i] - lank[i - 1]
    ans = ans + temp
    lank.remove(max(lank))

print(ans)
