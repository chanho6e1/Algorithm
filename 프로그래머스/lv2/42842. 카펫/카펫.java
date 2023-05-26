class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 3이상
        int sum = brown + yellow;
        
        for(int i=1; i<=sum; i++){
            int j = sum/i;
            
            if(j >= 3 && sum % i == 0){
                int w = Math.max(i, j);
                int h = Math.min(i, j);
                
                int center = (w-2) * (h-2);
                
                if(center == yellow){
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}