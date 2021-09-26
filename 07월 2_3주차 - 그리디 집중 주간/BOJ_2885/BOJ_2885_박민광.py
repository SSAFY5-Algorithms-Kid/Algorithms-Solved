K = int(input())
size = 1
count = 0
while size < K :
    size = size<<1

size2 = size

while K > 0 :
    if K >= size :
        K -= size

    else :
        size //= 2
        count += 1

print(size2, count)