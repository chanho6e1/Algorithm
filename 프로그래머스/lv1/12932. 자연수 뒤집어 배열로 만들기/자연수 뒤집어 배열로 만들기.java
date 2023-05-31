class Solution {
    public int[] solution(long n) {
        // int[] answer = {};
        
        char[] str = String.valueOf(n).toCharArray();
        
        int[] answer = new int[str.length];
        int idx = str.length - 1;
        for(char ch : str){
            answer[idx--] = ch - '0';
        }
        
        return answer;
    }
}