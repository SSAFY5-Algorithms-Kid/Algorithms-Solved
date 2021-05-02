import sys

t = int(input())
for _ in range(t):
    n = int(input())

    num = []
    for _ in range(n):
        num.append(sys.stdin.readline().rstrip())

    num.sort()
    check = 0
    for i in range(n-1):
        if num[i] == num[i+1][:len(num[i])]:
            check = 1
            break

    if(check==1):
        print('NO')
    else:
        print('YES')

