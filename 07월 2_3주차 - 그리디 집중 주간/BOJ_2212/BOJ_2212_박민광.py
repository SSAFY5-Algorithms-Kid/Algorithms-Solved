import sys

N = int(sys.stdin.readline().rstrip())
K = int(sys.stdin.readline().rstrip())
sensor = list(map(int,sys.stdin.readline().rstrip().split(' ')))

sensor.sort()
temp = []

for i in range(1,len(sensor)):
    temp.append(sensor[i] - sensor[i-1])

temp.sort()

for j in range(K-1):
    if len(temp) == 0:
        temp.append(0)
        break
    else:
        temp.pop()

print(sum(temp))