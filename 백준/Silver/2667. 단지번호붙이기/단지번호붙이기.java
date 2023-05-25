import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, map[][];
    static ArrayList<Integer> list;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                bfs(i, j);
                res++;
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(res).append("\n");
        for (Integer i : list)
            sb.append(i).append("\n");

        System.out.print(sb);
    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N | ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }

        list.add(cnt);
    }
}
