import java.util.*;

class Solution {
    
    static int[] one = {1, 2, 3, 4, 5};
    static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int N = answers.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i=0; i<N; i++){
            if (answers[i] == one[i%5]) sum1++;
            if (answers[i] == two[i%8]) sum2++;
            if (answers[i] == three[i%10]) sum3++;
        }
        
        int max = Math.max(sum1, Math.max(sum2, sum3));

        if (sum1 == max) list.add(1);
        if (sum2 == max) list.add(2);
        if (sum3 == max) list.add(3);
        
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}