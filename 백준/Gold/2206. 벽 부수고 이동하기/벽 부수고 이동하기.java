import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, map[][], res;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(res);
    }

    private static void bfs() {
        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(0, 0, 1, false));

        while (!q.isEmpty()) {
            Data now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                res = now.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) {

                    if (!visited[nx][ny][0] && !now.isDestroy) {
                        q.offer(new Data(nx, ny, now.cnt + 1, false));
                        visited[nx][ny][0] = true;
                    } else if (!visited[nx][ny][1] && now.isDestroy) {
                        q.offer(new Data(nx, ny, now.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else {
                    if (!now.isDestroy) {
                        q.offer(new Data(nx, ny, now.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        res = -1;
    }

    static class Data {
        int x, y;
        int cnt;
        boolean isDestroy;

        public Data(int x, int y, int cnt, boolean isDestroy) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isDestroy = isDestroy;
        }
    }
}
