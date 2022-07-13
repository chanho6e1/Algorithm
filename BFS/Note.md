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

3. <https://www.acmicpc.net/problem/2468>
```
from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
graph = []
maxnum = 0
for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        maxnum = max(graph[i][j], maxnum)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(depth, x, y, visited):
    q = deque()
    q.append([x,y])
    visited[x][y] = 1
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<n and 0<=ny<n:
                if visited[nx][ny] == 0 and graph[nx][ny]>depth:
                    visited[nx][ny] = 1
                    q.append([nx,ny])

res = 0
for i in range(maxnum):
    visited = [[0]*n for _ in range(n)]
    cnt = 0

    for j in range(n):
        for k in range(n):
            if graph[j][k] > i and visited[j][k] == 0:
                bfs(i, j, k, visited)
                cnt += 1

    res = max(res, cnt)

print(res)
```

4. <https://www.acmicpc.net/problem/2583>
```
from collections import deque
import sys
input = sys.stdin.readline

m, n, k = map(int, input().split())

graph = [[0]*n for _ in range(m)]

for i in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for j in range(y1, y2):
        for k in range(x1, x2):
            graph[j][k] = 1

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

cnt = []
q = deque()

for i in range(m):
    for j in range(n):
        if graph[i][j] ==0:
            temp = 1
            graph[i][j] = 1
            q.append([i,j])
            while q:
                x, y = q.popleft()
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if 0<=nx<m and 0<=ny<n and graph[nx][ny] == 0:
                        graph[nx][ny] = 1
                        temp+=1
                        q.append([nx,ny])
            cnt.append(temp)

print(len(cnt))
cnt.sort()
for i in cnt:
    print(i, end = ' ')
```
