import java.util.*;

class Solution {
    
    static int N;
    static boolean[] visited;
    static ArrayList<String> result;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        N = tickets.length;
        visited = new boolean[N];
        result = new ArrayList<>();
        
        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(result);
        answer = result.get(0).split(" ");
        return answer;
    }
    
    private static void dfs(String start, String route, int idx, String[][] tickets){
        if (idx == N){
            result.add(route);
            return;
        }
        
        for(int i=0; i<N; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], idx+1, tickets);
                visited[i] = false;
            }
        }
    }
}