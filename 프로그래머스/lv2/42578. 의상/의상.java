import java.util.*;

class Solution {
    
    static int N;
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        N = clothes.length;
        // head : 2, eye : 1 => 3 + 2*1
        // face : 3  => 3
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 1) + 1);
        }
        
        for(String key : map.keySet()){
            System.out.println(map.get(key));
            answer *= map.get(key);
        }
        
        
        return answer-1;
    }
}