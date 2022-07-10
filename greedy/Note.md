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

3. <https://www.acmicpc.net/problem/1946>
```
import sys
input = sys.stdin.readline
t = int(input())
for i in range(t):
    n = int(input()) #지원자의 숫자
    people = []
    for i in range(n):
        document, interview = map(int, input().split())
        people.append([document, interview])
    people = sorted(people, key=lambda x:x[0])
    Max = people[0][1]
    result = 1
    for i in range(1,n):
        if Max>people[i][1]:
            result += 1
            Max = people[i][1]

    print(result)
```

4. <https://www.acmicpc.net/problem/1026>
```
n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b = sorted(b, reverse=True)

result = 0
for i in range(n):
    result += a[i]*b[i]

print(result)
```

5. <https://www.acmicpc.net/problem/13904>
```
import sys
input = sys.stdin.readline
n = int(input())
task = []
for i in range(n):
    d, w = map(int, input().split())
    task.append([d,w])
task.sort()
date = task[-1][0]
result = 0

temp = []
while True:
    if date == 0:
        break
    while task and task[-1][0] >= date:
        temp.append(task.pop()[1])
    date -= 1
    if not temp:
        continue
    temp.sort()
    result += temp.pop()

print(result)
```

6. <https://www.acmicpc.net/problem/2217>
```
import sys
input = sys.stdin.readline
n = int(input())
w = []
for i in range(n):
    w.append(int(input()))

w.sort(reverse = True)
result = 0

for i in range(n):
    result = max(result, w[i]*(i+1))

print(result)
```

7. <https://www.acmicpc.net/problem/2839>
```
import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if (n == 4 || n == 7) {
			System.out.println(-1);
		}
		else if(n%5==0) {
			System.out.println(n/5);
		}
		else if(n%5 == 1 || n %5 == 3) {
			System.out.println((n/5)+1);
		}
		else if(n%5==2||n%5==4) {
			System.out.println((n/5)+2);
		}
		
	}
}
```

8. <https://www.acmicpc.net/problem/1789>
```
import sys
input = sys.stdin.readline

s = int(input())
n = 1
while n*(n+1)/2 <= s:
    n += 1

print(n-1)
```
