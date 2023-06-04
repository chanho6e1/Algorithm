class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        for(int i=1; i<numLog.length; i++){
            int preNum = numLog[i-1];
            if ((preNum+1) == numLog[i]){
                answer += 'w';
                continue;
            }
            if ((preNum-1) == numLog[i]){
                answer += 's';
                continue;
            }
            if ((preNum+10) == numLog[i]){
                answer += 'd';
                continue;
            }
            if ((preNum-10) == numLog[i]){
                answer += 'a';
                continue;
            }
        }
        
        return answer;
    }
}