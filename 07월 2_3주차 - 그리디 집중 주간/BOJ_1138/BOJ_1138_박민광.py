n=int(input())
a=list(map(int,input().split(' ')))

ans=list()

for i in range(n):
    ans.insert(a[n-1-i],n-i)

print(*ans)