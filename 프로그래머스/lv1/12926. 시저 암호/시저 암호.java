class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c!=' '){
                if(Character.isLowerCase(c)) { //소문자
                  c = (char) ((c - 'a' + n) % 26 + 'a');
              } else if(Character.isUpperCase(c)) { //대문자
                  c = (char) ((c - 'A' + n) % 26 + 'A');
              }
            }
            
            answer += c;
        }
        
        return answer;
    }
}