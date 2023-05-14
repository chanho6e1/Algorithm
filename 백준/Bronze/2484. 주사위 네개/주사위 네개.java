import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 참여하는 사람 수
        int res = 0;

        for (int i=0; i<N; i++){
            int[] dice = new int[4];
            int maxDice = 0;
            int secondDice = 0;
            int cnt = 0;

            int sum = 0;
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<4; j++){
                dice[j] = Integer.parseInt(st.nextToken());
            }

            for (int j=1; j<=6; j++){
                int tempCnt = 0;
                for (int k=0; k<4; k++){
                    if (j == dice[k])
                        tempCnt++;
                }

                if (cnt < tempCnt && maxDice < j){
                    cnt = tempCnt;
                    maxDice = j;
                    secondDice = 0;
                } else if (cnt == tempCnt && maxDice < j && cnt == 1) {
                    maxDice = j;
                } else if (cnt == tempCnt) {
                    secondDice = j;
                }
            }

            if (cnt == 4) { // 상금 계산
                sum = 50000 + maxDice * 5000;
            } else if (cnt == 3) {
                sum = 10000 + maxDice * 1000;
            } else if (cnt > 1 && secondDice > 0) {
                sum = 2000 + maxDice * 500 + secondDice * 500;
            } else if (cnt == 2) {
                sum = 1000 + maxDice * 100;
            } else if (cnt == 1) {
                sum = maxDice * 100;
            }

            res = Math.max(res, sum);

        }

        System.out.println(res);

    }
}
