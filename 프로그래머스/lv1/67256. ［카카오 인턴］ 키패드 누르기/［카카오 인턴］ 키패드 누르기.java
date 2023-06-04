class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 왼손 : *, 오른손 : #
        int left = 10;
        int right = 12;
        
        for(int n : numbers){
            if (n == 1 || n == 4 || n == 7) {
                answer += "L";
                left = n;
            }
            else if(n == 3 || n == 6 || n == 9) {
                answer += "R";
                right = n;
            }
            else {
                if (n == 0) n = 11;
                
                int leftDiff = Math.abs(left - n)/3+ Math.abs(left - n)%3;
                int rightDiff = Math.abs(right - n)/3 + Math.abs(right - n)%3;
                
                if(leftDiff < rightDiff){
                    answer += "L";
                    left = n;
                } else if(leftDiff > rightDiff){
                    answer += "R";
                    right = n;
                } else{
                    if(hand.equals("right")){
                        answer += "R";
                        right = n;
                    } else{
                        answer += "L";
                        left = n;
                    }
                }
            }
        }
        
        return answer;
    }
}