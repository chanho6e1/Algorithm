import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static ArrayList<Node>[] list, reverseList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 다익스트라 : 출발지 -> X -> 출발지
        // 1. 출발지 -> X
        // 2. X -> 출발지
        N = Integer.parseInt(st.nextToken()); // 마을
        M = Integer.parseInt(st.nextToken()); // 도로
        X = Integer.parseInt(st.nextToken()); // X번 마을

        int[] dist = new int[N + 1];
        int[] reverseDist = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);

        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()); // 도로를 지나는데 필요한 시간

            list[a].add(new Node(b, t));
            reverseList[b].add(new Node(a, t));
        }

        dijkstra(list, dist, X);
        dijkstra(reverseList, reverseDist, X);

        int result = 0;
        for (int i=1; i<=N; i++)
            result = Math.max(result, dist[i] + reverseDist[i]);

        System.out.println(result);
    }

    private static void dijkstra(ArrayList<Node>[] list, int[] dist, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        boolean[] visited = new boolean[N + 1];

        dist[x] = 0;

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if (visited[now.v]) continue;
            visited[now.v] = true;

            for (Node next : list[now.v]){
                if (dist[next.v] > dist[now.v] + next.cost){
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
