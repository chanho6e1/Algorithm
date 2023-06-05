import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        // 연속 펄스 부분 수열을 만들어, 가장 큰 합
        // 펄스에 관계없이 부호만 다른 sum 값이 발생 => Math.abs()를 사용하자!
        
        int n = sequence.length;
        long[] sum = new long[n+1];
        
        for(int i=1; i<n+1; i++){
            if(i%2==0)
                sum[i] = sum[i-1] + sequence[i-1]*-1;
            else
                sum[i] = sum[i-1] + sequence[i-1];
        }
        
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        
        for(long num : sum){
            if (max < num) max = num;
            if (min > num) min = num;
        }
        
        return Math.abs(max - min);
    }
}