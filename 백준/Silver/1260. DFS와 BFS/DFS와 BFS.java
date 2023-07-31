import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++)
            Collections.sort(list[i]);

        visited = new boolean[N + 1];
        dfs(V);
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(V);

        System.out.print(sb);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");

            for (int i : list[now]) {
                if (visited[i]) continue;

                q.offer(i);
                visited[i] = true;
            }
        }
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v + " ");

        for (int i : list[v]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }
}
