import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        
//         int[][] dp = new int[N][arr[N-1].length];
        
//         dp[0][0] = arr[0][0];
        
//         for (int i=1; i<N; i++){
            
//             dp[i][0] = dp[i-1][0] + arr[i][0];
//             dp[i][i] = dp[i-1][i] + arr[i][i];
            
//             for (int j=1; j<i; j++){
//                 dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                
//                 answer = Math.max(answer, dp[i][j]);
//             }
//         }
        
//         return answer;
        
        for(int i = 1; i < n ; i++) {
	for(int j = 0; j < triangle[i].length ; j++) {

		if(j == 0) {//왼쪽 끝
			triangle[i][j] += triangle[i-1][j];
		}
		else if(j == i) {//오른쪽 끝
			triangle[i][j] += triangle[i-1][j-1];
		}
		else {
			triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
		}

		answer = Math.max(answer, triangle[i][j]);
	}
}
return answer;
    }
}