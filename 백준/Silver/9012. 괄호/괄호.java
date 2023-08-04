import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            char[] arr = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char a : arr) {
                if (a == '(') stack.push('(');
                else {
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(')');
                }
            }

            if (stack.size() == 0) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}