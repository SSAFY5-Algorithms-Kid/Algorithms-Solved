from itertools import combinations_with_replacement
nums = [1, 5, 10, 50]
N = int(input())
result = []
for e in combinations_with_replacement(range(4), N):
    num_sum = 0
    for i in e:
        num_sum += nums[i]
    if num_sum not in result:
        result.append(num_sum)
print(len(result))
