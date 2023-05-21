import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            char[] chars = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char ch : chars){
                if (ch == '(')
                    stack.push(ch);
                else{
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else stack.push(ch);
                }
            }

            if (stack.isEmpty()) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
