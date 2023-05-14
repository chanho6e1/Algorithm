import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{

        int start, end, cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Node(a, b, c));
        }

        parent = new int[N+1];
        for (int i=1; i<=N; i++)
            parent[i] = i;

        int res = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if (find(now.start) != find(now.end)){
                union(now.start, now.end);
                res += now.cost;
            }
        }


        System.out.println(res);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            if (a > b)
                parent[b] = a;
            else
                parent[a] = b;
        }
    }

    private static int find(int num){
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }
}
