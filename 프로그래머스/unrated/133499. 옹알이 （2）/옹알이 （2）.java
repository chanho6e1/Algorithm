class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String bab : babbling){
            bab = bab.replaceAll("aya", "1");
            if(bab.contains("11")) continue;
            
            bab = bab.replaceAll("ye", "2");
            if(bab.contains("22")) continue;
            
            bab = bab.replaceAll("woo", "3");
            if(bab.contains("33")) continue;
            
            bab = bab.replaceAll("ma", "4");
            if(bab.contains("44")) continue;
            
            bab = bab.replaceAll("1", "");
            bab = bab.replaceAll("2", "");
            bab = bab.replaceAll("3", "");
            bab = bab.replaceAll("4", "");
            
            if(bab.equals("")) answer++;
            
            System.out.println(bab);
        }
        
        return answer;
    }
}