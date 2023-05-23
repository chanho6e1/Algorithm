import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int[] command : commands){
            int[] temp = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(temp);
            list.add(temp[command[2]-1]);
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}