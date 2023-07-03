class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i=0; i<s.length(); i++){
            int temp = -1;
            
            for (int j=i-1; j>=0; j--){
                if (s.charAt(i) == s.charAt(j)){
                    temp = i-j;
                    break;
                }
            }
            
            answer[i] = temp;
        }
        
        return answer;
    }
}