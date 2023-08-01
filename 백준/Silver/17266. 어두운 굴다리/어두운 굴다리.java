import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        int[] input = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;

        while (left<right){
            int mid = (left + right) / 2;
            int now = 0;

            for (int i : input){
                int start = i - mid;
                int end = i + mid;

                if (now < start) break;
                else now = end;
            }

            if (N<=now)
                right = mid;
            else left = mid + 1;
        }

        System.out.print(left);
    }
}
