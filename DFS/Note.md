1. <https://www.acmicpc.net/problem/9372>
```
T = int(input())

for _ in range(T):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    for i in range(m):
        n1, n2 = map(int, input().split())
        graph[n1].append(n2)
        graph[n2].append(n1)

    visited = [0] * (n+1)

    def dfs(v, cnt):
        visited[v] = 1

        for i in graph[v]:
            if visited[i] == 0:
                cnt = dfs(i, cnt + 1)
        return cnt

    print(dfs(1,0))
```
    
2. <https://www.acmicpc.net/problem/1260>
```
import sys
input = sys.stdin.readline
from collections import deque

n, m, v = map(int, input().split())
graph = [[] for _ in range(n+1)]

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(len(graph)):
    graph[i].sort()

visited = [0] * (n+1)

def dfs(v):
    visited[v] = 1
    print(v, end=" ")
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

def bfs(v):
    q = deque()
    q.append(v)
    visited[v] = 1

    while q:
        now = q.popleft()
        print(now, end = " ")

        for j in graph[now]:
            if not visited[j]:
                q.append(j)
                visited[j] = 1

dfs(v)
visited = [0] * (n+1)
print()
bfs(v)
```

3. <>
```
```

