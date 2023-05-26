import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int N = nums.length/2;
        
        if(map.size() > N) answer = N;
        else
            answer = map.size();
        
        
        return answer;
    }
}