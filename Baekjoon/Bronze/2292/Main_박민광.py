N = int(input())

temp = 1
i = 1
while(1):
    if temp >= N:
        break
    temp = temp + (6 * i)
    i = i + 1

print(i)