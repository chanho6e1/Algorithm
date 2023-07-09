import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] list;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        list = new ArrayList[n+1];
        dist = new int[n+1];
        
        for (int i=1; i<=n; i++)
            list[i] = new ArrayList<Integer>();
        
        for (int[] e : edge){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        bfs(n);
        
        Arrays.sort(dist);
        int max = dist[n];
        
        for (int d : dist){
            if (max == d) answer++;
        }
        
        return answer;
    }
    
    private static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (Integer i : list[now]){
                if (visited[i]) continue;
                
                dist[i] = dist[now] + 1;
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}