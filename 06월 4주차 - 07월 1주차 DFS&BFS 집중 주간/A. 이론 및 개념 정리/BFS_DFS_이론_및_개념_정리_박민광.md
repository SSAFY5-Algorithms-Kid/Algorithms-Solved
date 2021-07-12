[https://www.acmicpc.net/problem/1260](https://www.acmicpc.net/problem/1260)

```
import sys
from collections import deque
sys.setrecursionlimit(10**6)

def dfs(V):
    visit[V] = 1
    dfs_result.append(V)
    for i in board[V]:
        if visit[i] == 0:
            visit[i] = 1
            dfs(i)

def bfs(V):
    visit = [0] * (N + 1)
    visit[V] = 1
    bfs_result.append(V)
    tmp = deque()
    tmp.append(V)
    while tmp:
        V = tmp.popleft()
        for i in board[V]:
            if visit[i] == 0: # visit 처리를 리스트 append로 visit안에 값이 있는가를 검색하게했었는데, 다이렉트로 인덱스의 값이 0인지를 비교하는 것이 효율적
                bfs_result.append(i)
                tmp.append(i)
                visit[i] = 1


N, M, V = map(int, sys.stdin.readline().split())
board = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    board[a].append(b)
    board[b].append(a)
for i in range(len(board)):
    board[i].sort()

visit = [0] * (N + 1)
dfs_result = []
bfs_result = []
dfs(V)
bfs(V)
print(*dfs_result)
print(*bfs_result)
```

> DFS와 BFS를 스터디에서 첫 주제로 잡고, 많은 양의 문제를 풀기로 정했다!

문제를 풀기 전에, 다시 한번 개념을 다지기 위해서 내가 생각하기에 DFS와 BFS의 개념을 잡기 좋았던 백준 1260문제를

python으로 다시 한번 풀어보았다.

DFS는 재귀를 이용해서, BFS는 큐를 이용해서 풀었는데, 문제는 응용보다는 기본개념에 충실한 느낌이다.

![BFSDFS](https://user-images.githubusercontent.com/50613287/122958701-e2115b00-d3bd-11eb-9502-ce70d570d26a.png)



> 위 그림과 같이, BFS는 너비 우선 탐색으로 시작 노드 A부터 한 단계씩 내려오면서 같은 레벨을 먼저 순회한다.  
> ( A - B - C - D - G - H - I - E - F - J)  
> DFS는 시작 노드에서 연결된 자식 노드를 타고 제일 끝 레벨까지 순회하고 나서,  
> 다시 돌아가 다른 형제 노드의 자식 노드를 거치며 순회한다.  
> ( A - B - D - E - F - C - G - H - I - J)

---

다시 맨 위에 있는 백준-1260 문제로 돌아가보면, 그래프를 DFS와 BFS로 탐색하는 문제인데 

그래프를 인접 행렬을 사용해서 표현할지? 인접 리스트를 사용해서 표현할지?가 먼저 고민해야하는 부분이다

나는 java 풀이를 할때, 인접 행렬을 사용했었기 때문에 인접리스트를 사용했다.

시간이 70ms으로 풀이를 한 다른 코드들을 참고하면서, visit을 처리할때 리스트로 만들어서 방문한 값들을 추가해주고

in 연산자를 사용해서, 그 값이 있는가 없는가를 판단했었는데...

참고한 풀이에서는 visit을 1차원 배열로 만들고, 인덱스에 맞춰서 0과 1로 방문처리를 해주는 로직을 사용하고 있었다.

> DFS의 경우 풀이는, V를 시작으로 인접리스트에 방문 안한 노드가 있다면, 그 노드로 재귀를 타고 방문 안한 노드가 없을때까지  
> 들어간다. 이후에 한 단계씩 빠져나오면서, 모든 노드를 탐색하고 수행을 마친다.

---

> BFS의 경우에는 queue를 사용하는데, python의 리스트 자료구조를 사용하면, 큐의 구현은 어렵지않다.  
> 다만, 리스트의 pop(0) 연산의 시간복잡도가 O(n)이기 때문에, deque를 import해서 사용하면, 시간복잡도를 줄일수 있다.  
> deque는 '양방향 큐'로 양 끝의 append와 pop연산이 리스트보다 빠르다.   
> 풀이는 deque에 시작노드를 넣어주고, 인접리스트에 있는 방문하지 않은 값을 모두 deque에 추가해주고 방문처리를 해준다.  
> deque에 추가된 노드들을 모두 탐색하면서, 수행을 마친다.
