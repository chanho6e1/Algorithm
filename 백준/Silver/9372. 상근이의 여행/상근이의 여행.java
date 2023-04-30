import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] visited;
    static int N, M, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 국가의 수
            M = Integer.parseInt(st.nextToken()); // 비행기 종류

            map = new int[N+1][N+1];
            visited = new boolean[N+1];

            res = 0;

            for (int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = map[b][a] = 1;
            }

            bfs();
            sb.append(res-1).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()){
            res++;
            int now = q.poll();
            for (int i=1; i<=N; i++){
                if (map[now][i] != 0 && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
