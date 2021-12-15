N,S,R = map(int, input().split(' '))
H = list(map(int, input().split(' ')))
E = list(map(int, input().split(' ')))

cnt = S
for i in range(S):
    for j in range(R):
        if H[i]==E[j] or abs(H[i]-E[j])==1:
            cnt -= 1
            del E[j]
            R-= 1
            break

print(cnt)