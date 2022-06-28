### 매 순간 최적의 선택을 하자
1. <https://www.acmicpc.net/problem/5585>
```
n = 1000 - int(input())
result = 0
num = [500, 100, 50, 10, 5, 1]
for c in num:
    result += n//c
    n %= c

print(result)
```

2. <https://www.acmicpc.net/problem/11047>
```
n, k = map(int, input().split())
coin = []
for i in range(n):
    coin.append(int(input()))
coin.reverse()
result = 0
for c in coin:
    if c>k:
        continue
    result += k//c
    k %= c

print(result)
```
