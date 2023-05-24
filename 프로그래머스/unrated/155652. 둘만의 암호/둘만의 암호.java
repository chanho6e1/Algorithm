class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            int cnt = 0;
            for(int j=0; j<index; j++){
                ch++;
                if(ch > 'z') ch -= 26;
                if(skip.contains(ch+"")) j--;
            }
            
            answer += ch;
        }
        
        return answer;
    }
}