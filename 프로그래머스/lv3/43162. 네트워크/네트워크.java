import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            
            while(!q.isEmpty()){
                int now = q.poll();
                visited[now] = true;
                
                for(int j=0; j<n; j++){
                    if(now != j && computers[now][j] == 1 && !visited[j])
                        q.offer(j);
                }
            }
            answer++;
        }
        
        return answer;
    }
}