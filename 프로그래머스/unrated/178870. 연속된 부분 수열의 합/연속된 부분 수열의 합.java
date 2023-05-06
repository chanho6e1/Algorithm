class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        
        for(int l = 0, r = 0; l < N; l++){
            while(r<N && sum <k){
                sum += sequence[r++];
            }
            
            if(sum == k){
                int range = r - l - 1;
                if((right - left) > range){
                    left = l;
                    right = r-1;
                }
            }
            
            sum -= sequence[l];
        }
        
        
        return new int[]{left, right};
    }
}