import sys

form = input()
if(form == '0'):
    print('W')
    sys.exit(0)

ans = ""
p = form.find('x')
ax = ''
if p != -1:
    ax = form[:p]
    ax = int(ax)//2

bx = form[p+1:]

if ax != '':
    if(ax==1):
        ax = ''
    elif(ax==-1):
        ax = '-'
    ans = ans + str(ax) + "xx"
if bx != '':
    if(int(bx)==1):
        bx = '+'
        if(ans == ''):
            ans = 'x+W'
        else:
            ans = ans + bx + 'x+W'
    elif(int(bx)==-1):
        bx = '-'
        ans = ans + bx + 'x+W'
    elif(int(bx)==0):
        ans = ans + '+W'
    else:
        ans = ans + bx + 'x+W'

else:
    ans = ans + '+W'
print(ans)