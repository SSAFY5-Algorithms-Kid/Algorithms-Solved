import sys

while True: #try ~ except가 없으면 EOF에러가 발생해서 안에 넣어줌. 백준 인풋 불편...
    try:
        x = int(input())
        x *= 10000000 # 나노미터?? 그거 때문에 곱해줌

        # 레고입력 받아줌
        lego = []
        N = int(input())
        for _ in range(N):
            lego.append(int(sys.stdin.readline()))

        lego.sort()

        # 테스트 케이스만 봐도 값이 순서없이 이상하게 들어옴. 정렬을 해줌

        i = 0
        j = N-1
        check = True

        #알고리즘 분류를 보고 힌트를 얻음. 이분탐색!!
        while i < j:
            if lego[i] + lego[j] == x:
                print('yes',lego[i],lego[j])
                check = False
                break
            elif lego[i] + lego[j] < x:
                i += 1
            else:
                j -= 1
        if check:
            print('danger')
    except:
        break