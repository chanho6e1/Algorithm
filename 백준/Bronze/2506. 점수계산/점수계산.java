import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        /* 연속적으로 답을 맞출 경우, K번째 문제는 K점 */
        int N = Integer.parseInt(br.readLine()); // 문제 개수
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1){
                sum += cnt;
                cnt++;
            }else {
                cnt = 1;
            }
        }

        System.out.println(sum);
    }
}
