# 210303 수 카드 정렬하기

import heapq

N = int(input())

card = []
for _ in range(N):
    heapq.heappush(card, int(input()))

answer = 0

for _ in range(N-1):
    tmp1 = heapq.heappop(card)
    tmp2 = heapq.heappop(card)
    answer += (tmp1 + tmp2)
    heapq.heappush(card, tmp1+tmp2)
print(answer)