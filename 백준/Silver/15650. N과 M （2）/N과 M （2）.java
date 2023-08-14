import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        // nCm

        Comb(1, 0);

        System.out.print(sb);
    }

    private static void Comb(int start, int idx) {

        if (idx == m) {
            for (int i = 0; i < m; i++)
                sb.append(arr[i] + " ");
            sb.append("\n");

            return;
        }

        for (int i = start; i <= n; i++) {
            arr[idx] = i;
            Comb(i+1, idx+1);
            arr[idx] = 0;
        }
    }
}
