class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int c1 = 0, c2 = 0;
        int idx = 0;
        
        while(idx < goal.length){
            if(c1 < cards1.length && goal[idx].equals(cards1[c1])){
                c1++;
                idx++;
            }else if(c2 < cards2.length && goal[idx].equals(cards2[c2])){
                c2++;
                idx++;
            }else{
                answer = "No";
                break;
            }
            
        }
        
        return answer;
    }
}