import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 명령의 수
        Deque<Integer> dq = new LinkedList<>();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch (op){
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (dq.isEmpty()) sb.append(-1);
                    else sb.append(dq.pollFirst());
                    sb.append("\n");
                    break;
                case "pop_back":
                    if (dq.isEmpty()) sb.append(-1);
                    else sb.append(dq.pollLast());
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(dq.size());
                    sb.append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() == true ? 1 : 0);
                    sb.append("\n");
                    break;
                case "front":
                    if (dq.isEmpty()) sb.append(-1);
                    else sb.append(dq.getFirst());
                    sb.append("\n");
                    break;
                case "back":
                    if (dq.isEmpty()) sb.append(-1);
                    else sb.append(dq.getLast());
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
