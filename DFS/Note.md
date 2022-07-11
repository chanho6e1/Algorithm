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

3. <https://www.acmicpc.net/problem/2606>
```
import sys
input = sys.stdin.readline
n = int(input()) #컴퓨터 수
c = int(input())
net = [[] for _ in range(n+1)]
for _ in range(c):
    n1, n2 = map(int, input().split())
    net[n1].append(n2)
    net[n2].append(n1)

visited = [0] * (n+1)

def dfs(v):
    visited[v] = 1
    for i in net[v]:
        if not visited[i]:
            dfs(i)

dfs(1)
print(visited.count(1)-1)
```

4. <https://www.acmicpc.net/problem/11724>
```
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
    graph[u].sort()
    graph[v].sort()

def dfs(v, visited):
    visited[v] = 1
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i, visited)


visited = [0]*(n+1)
cnt = 0

for i in range(1, n+1):
    if visited[i] == 0:
        cnt += 1
        dfs(i, visited)

print(cnt)
```
