n = int(input())
d = [0] * (n + 1)
p = [0] + list(map(int, input().split())) # 입력!
d[1] = p[1] # 1개를 사는 비용 먼저 넣어줌
for i in range(2, n + 1):   # 2개 사는 경우부터 반복
    for j in range(1, i + 1):       # i까지만큼만 반복하면 되니까 (i+1하면 i까지 반복)
        if d[i] < d[i - j] + p[j]:  # 2개 사는 값이 1개 두번 사는 거보다 작다면??
            d[i] = d[i - j] + p[j]  # 2개사는 값을 1개 두번 사는 값으로 바꾼다!!
print(d[n])  # 이런식으로 n 개까지의 값을 넣어쭈고, n개 사는값만 출력!!
