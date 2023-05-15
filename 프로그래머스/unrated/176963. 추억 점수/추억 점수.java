import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int i=0;
        for (String[] photo : photos){
            int sum = 0;
            for (String ph : photo){
                if (map.containsKey(ph))
                    sum += map.get(ph);
            }
            answer[i++] = sum;
        }
        
        return answer;
    }
}