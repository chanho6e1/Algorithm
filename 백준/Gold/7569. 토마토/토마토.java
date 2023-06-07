import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0, 0, 0}; // 상,하,좌,우,위,아래
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int N, M, H, map[][][];
    static Queue<Data> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 쌓아 올려지는 상자 수

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if (map[i][j][k] == 1) q.offer(new Data(i, j, k));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            Data now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if (nx < 0 || ny < 0 || nz <0 || nx >= N || ny >= M || nz >= H) continue;
                if (map[nz][nx][ny] != 0) continue;

                map[nz][nx][ny] = map[now.z][now.x][now.y] + 1;
                q.offer(new Data(nz, nx, ny));
            }

        }

        int result = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) return -1;

                    result = Math.max(result, map[i][j][k]);
                }
            }
        }

        if (result == 1) return 0;

        return result - 1;
    }
}

class Data {
    int x, y, z;

    public Data(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
