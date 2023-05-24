class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String bab : babbling){
            
            if (bab.contains("ayaaya")) continue;
            if (bab.contains("yeye")) continue;
            if (bab.contains("woowoo")) continue;
            if (bab.contains("mama")) continue;
            
            bab = bab.replaceAll("aya", " ");
            
            bab = bab.replaceAll("ye", " ");
            
            bab = bab.replaceAll("woo", " ");
            
            bab = bab.replaceAll("ma", " ");
            
            bab = bab.replaceAll(" ", "");
            
            if(bab.equals("")) answer++;
            
            System.out.println(bab);
        }
        
        return answer;
    }
}