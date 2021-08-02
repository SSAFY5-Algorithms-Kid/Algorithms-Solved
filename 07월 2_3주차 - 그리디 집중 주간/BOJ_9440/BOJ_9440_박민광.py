import sys

while(1):
    tmp = list(map(str,sys.stdin.readline().rstrip().split(' ')))
    if tmp[0] == '0':
        sys.exit(0)
    tmp.pop(0)
    tmp.sort()

    zeroc = tmp.count('0')

    num1 = ''
    num2 = ''
    for i in range(len(tmp)):
        if i % 2 == 0:
            num1 = num1 + tmp[i]
        else:
            num2 = num2 + tmp[i]

    if zeroc % 2 == 1 and num1[0] == '0' and num2[0] == '0':
        num1 = num1[1:len(num1)]
        num2 = '0' + num2

    if num1[0] == '0':
        temp = 1
        for k in range(len(num1)):
            if int(num1[k]) > 0:
                temp = k
                break
        num1 = list(num1)
        num1[0] = num1[k]
        num1[k] = '0'
        num1 = ''.join(num1)

    if num2[0] == '0':
        temp = 1
        for k in range(len(num2)):
            if int(num2[k]) > 0:
                temp = k
                break
        num2 = list(num2)
        num2[0] = num2[k]
        num2[k] = '0'
        num2 = ''.join(num2)

    print(int(num1)+int(num2))