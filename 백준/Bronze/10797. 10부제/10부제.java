import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 날짜의 일의 자리 수

        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<5; i++){
            int num = Integer.parseInt(st.nextToken());
            if (N == num) res++;
        }

        System.out.println(res);
    }
}
