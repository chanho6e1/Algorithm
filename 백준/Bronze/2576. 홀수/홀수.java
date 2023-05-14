import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 홀수의 합과 최솟값 구하기
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<7; i++){
            int num = Integer.parseInt(br.readLine());
            if (num %2 == 1){
                sum += num;
                min = Math.min(min, num);
            }
        }

        if (sum == 0)
            sb.append("-1");
        else
            sb.append(sum).append("\n").append(min);
        System.out.println(sb);
    }
}
