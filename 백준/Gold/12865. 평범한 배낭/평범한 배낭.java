import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] input = new int[N+1][2];

        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            input[i][0] = Integer.parseInt(st.nextToken()); // 무게
            input[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(input[i][0] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-input[i][0]] + input[i][1]);
            }
        }

        System.out.println(dp[N][K]);
    }
}
