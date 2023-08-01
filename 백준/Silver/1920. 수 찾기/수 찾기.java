import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            boolean flag = false;

            while (left < right) {
                if (A[left] == num || A[right] == num) {
                    flag = true;
                    break;
                }

                int mid = (left + right) / 2;

                if (num < A[mid]) right = mid;
                else if (num > A[mid]) left = mid + 1;
                else {
                    flag = true;
                    break;
                }

            }

            if (flag) System.out.println(1);
            else System.out.println(0);
        }
    }
}
