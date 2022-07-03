1. <https://www.acmicpc.net/problem/2178>
```
import sys
input = sys.stdin.readline
from collections import deque
n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(input()))

q = deque()
q.append([0,0])
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while q:
    x, y = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<n and 0<=ny<m and graph[nx][ny] == '1':
            graph[nx][ny] = int(graph[x][y]) + 1
            q.append([nx,ny])

print(graph[n-1][m-1])
```

2. <https://www.acmicpc.net/problem/2606>
```
from collections import deque
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

def bfs(v):
    q = deque()
    q.append(v)
    while q:
        now = q.popleft()
        for i in net[now]:
            if not visited[i]:
                q.append(i)
                visited[i] = 1
bfs(1)
print(visited.count(1)-1)
```

3. 
