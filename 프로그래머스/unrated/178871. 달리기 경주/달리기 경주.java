import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<players.length; i++)
            map.put(players[i], i);

        for (String calling : callings){
            int now = map.get(calling);
            int front = now - 1;
            String temp = players[front]; // 추월당할 선수의 이름
            players[front] = players[now];
            players[now] = temp;
            
            map.put(players[front], front);
            map.put(players[now], now);
        }
        
        return players;
    }
}