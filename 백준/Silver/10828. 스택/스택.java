import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(st.nextToken()); // 명령의 수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch (op) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty()) sb.append("-1\n");
                    else sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "top":
                    if (stack.isEmpty()) sb.append("-1\n");
                    else sb.append(stack.peek()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
