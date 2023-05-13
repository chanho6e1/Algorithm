import java.util.*;

class Solution {
    
    static int N, M;
    static int[][] visited;
    
    public int solution(int[][] maps) {
        
        N = maps.length;
        M = maps[0].length;
        
        visited = new int[N][M];
        
        bfs(maps);
        
        int answer = visited[N-1][M-1];
        
        if(answer == 0) answer = -1;
        
        return answer;
    }
    
    public void bfs(int[][] maps){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        visited[0][0] = 1;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[nx][ny]!=0) continue;
                if(maps[nx][ny]==0) continue;
             
                visited[nx][ny] = visited[x][y] + 1;
                
                q.offer(new int[]{nx, ny});
            }
        }
    }
}