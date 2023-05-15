class Solution {
    public String solution(int n) {
        
        String answer = "";
        
        String[] nums = {"4", "1", "2"};
        while(n>0){
            int remain = n % 3;
            n /= 3;
            
            if(remain == 0) n--;
            
            answer = nums[remain] + answer;
        }
        
        return answer;
    }
}