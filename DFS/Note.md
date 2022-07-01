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
    
    2.
