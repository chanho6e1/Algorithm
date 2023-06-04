class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        char[] ch = phone_number.toCharArray();
        for(int i=0; i<phone_number.length()-4; i++)
            answer += '*';
        
        for(int i=phone_number.length()-4; i<phone_number.length(); i++)
            answer += ch[i];
        
        return answer;
    }
}