import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점

        list = new ArrayList[N+1];
        for (int i=0; i<N+1; i++)
            list[i] = new ArrayList<>();

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i=0; i<N+1; i++)
            Collections.sort(list[i]);

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.print(sb);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            sb.append(now + " ");
            for (Integer i : list[now]){
                if (visited[i]) continue;
                q.offer(i);
                visited[i] = true;
            }
        }
    }

    private static void dfs(int v) {
        sb.append(v + " ");
        visited[v] = true;

        for (Integer i : list[v]){
            if (visited[i]) continue;
            dfs(i);
        }
    }
}
