class Solution {
    
    static int answer;
    static int[] arr;
    
    public int solution(int[] number) {
        
        arr = new int[3];
        
        Combination(number, 0, 0);
        
        return answer;
    }
    
    private static void Combination(int[] number, int idx, int start){
        if (idx == 3){
            int sum = 0;
            for (int n : arr){
                sum += n;
            }
            
            if (sum == 0) answer++;
            
            return;
        }
        
        for(int i=start; i<number.length; i++){
            arr[idx] = number[i];
            Combination(number, idx+1, i+1);
            arr[idx] = 0;
        }
    }
}