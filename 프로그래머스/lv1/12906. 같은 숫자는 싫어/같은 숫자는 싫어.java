import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int preNum = -1;
        for(int n : arr){
            if(preNum != n) list.add(n);
            preNum = n;
        }
        
        // System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}