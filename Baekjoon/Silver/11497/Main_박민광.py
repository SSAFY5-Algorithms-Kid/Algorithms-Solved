T = int(input()) #테스트 케이스 입력

for i in range(T):
    N=int(input()) #나무개수 입력
    ans = 0 #높이 차 결과변
    tree = list(map(int,input().split()))수 #입력을 리스트로
    tree.sort() #정렬
    for j in range(2,N):
        ans = max(ans,abs(tree[j]-tree[j-2]))
    print(ans)

# 1 2 3 4 5 6
# 5 3 1 2 4 6 와 같은 형태가 이상적인 최소값차이 형태