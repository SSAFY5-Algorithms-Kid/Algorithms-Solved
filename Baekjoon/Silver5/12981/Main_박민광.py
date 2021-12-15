rgb = list(map(int, input().split(' ')))

ans = 0

for i in range(3):
    if rgb[i] >= 3:
        ans = ans + rgb[i] // 3
        rgb[i] = rgb[i] % 3

sub = min(rgb)

if sub > 0:
    for i in range(3): rgb[i] = rgb[i] - sub

ans = ans + sub

rgb.sort()
sub2 = rgb[1]

if sub2 > 0:
    for i in range(3): rgb[i] = rgb[i] - sub2

ans = ans + sub2

for i in range(3):
    if rgb[i] > 0:
        ans = ans + 1

print(ans)