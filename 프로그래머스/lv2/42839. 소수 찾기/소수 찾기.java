import java.util.*;

class Solution {
    
    static int N, nums[], arr[];
    static boolean[] visited;
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 순열 - 부분집합
        N = numbers.length();
        nums = new int[N];
        visited = new boolean[N];
        set = new HashSet<>();
        
        for (int i=0; i<N; i++)
            nums[i] = numbers.charAt(i) - '0';
        
        for (int i=1; i<=N; i++){
            visited = new boolean[N];
            arr = new int[i];
            Permutation(0, i);
        }
        
        for (Integer num : set){
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean isPrime(int n){
        if (n == 0 || n == 1) return false;
        for (int i=2; i<= Math.sqrt(n); i++){
            if (n%i==0) return false;
        }
        return true;
    }
    
    private static void Permutation(int idx, int n){
        
        if (idx == n){
            String number = "";
            for (int i=0; i<n; i++){
                number += arr[i] + "";
            }
            set.add(Integer.parseInt(number));
            return;
        }
        
        for (int i = 0; i<N; i++){
            if (visited[i]) continue;
            
            arr[idx] = nums[i];
            visited[i] = true;
            
            Permutation(idx+1, n);
            visited[i] = false;
        }
    }
}