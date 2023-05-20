import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String[] target = today.replace(".", " ").split(" ");
        
        int tyear = Integer.parseInt(target[0]);
        int tmonth = Integer.parseInt(target[1]);
        int tday = Integer.parseInt(target[2]);
        
        int cnt = (tyear * 12 * 28) + (tmonth * 28) + tday;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<String,Integer>();
        for (String term : terms){
            String[] str = term.split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }
        
        for (int i=0; i<privacies.length; i++){
            String[] str = privacies[i].split(" ");
            int term = map.get(str[1]);
            
            String[] days = str[0].replace(".", " ").split(" ");
            int year = Integer.parseInt(days[0]);
            int month = Integer.parseInt(days[1]) + term;
            int day = Integer.parseInt(days[2]);
            
            int temp = (year * 12 * 28) + (month * 28) + day - 1;
            if(temp < cnt)
                result.add(i+1);
        }
        
        Collections.sort(result);
        return result.stream().mapToInt(integer -> integer).toArray();
    }
}