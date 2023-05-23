class Solution {
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String bab : babbling){
            bab = bab.replaceFirst("aya", "1");
            bab = bab.replaceFirst("ye", "1");
            bab = bab.replaceFirst("woo", "1");
            bab = bab.replaceFirst("ma", "1");
            
            bab = bab.replace("1", "");
            System.out.println(bab);
            
            if(bab.length() ==0 ) answer += 1;
        }
        
        return answer;
    }
}