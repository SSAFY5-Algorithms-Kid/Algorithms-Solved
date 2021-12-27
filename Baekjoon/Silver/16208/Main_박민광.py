import sys #stdin을 사용안하고, input()으로만 입력을 받으면, 4점 부분점수만 받고 통과하지 못한다!

N = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().rstrip().split(' ')))

total = sum(nums)
nums.sort()

ans = 0
for i in range(len(nums)-1):
    total = total - nums[i]
    ans = ans + (total* nums[i])

print(ans)