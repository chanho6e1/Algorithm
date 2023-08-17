import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i < N + 1; i++) {
            if (isPrime(i)) sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n % i == 0) return false;
        }
        return true;
    }
}
