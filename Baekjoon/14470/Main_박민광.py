cel = []
ans = 0
for _ in range(5):
    cel.append(int(input()))

origin, target, onfreeze, unfreeze, normal = cel[0], cel[1], cel[2], cel[3], cel[4]

if (target - origin) >= target:
    ans = (abs(origin) * onfreeze) + unfreeze + (target * normal)
else:
    ans = (target - origin) * normal

print(ans)