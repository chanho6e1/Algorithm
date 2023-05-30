import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean check;
    static int result;
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            check = false;

            bfs();
            down();

            if (!check) break;

            result++;
        }

        System.out.println(result);
    }

    private static void down() {
        for (int j = 0; j < 6; j++) {
            Queue<Character> q = new LinkedList<>();
            int idx = 11;

            for (int i = idx; i >= 0; i--) {
                if (map[i][j] == '.') continue;

                q.offer(map[i][j]);

                map[i][j] = '.';
            }

            while (!q.isEmpty()) {
                map[idx--][j] = q.poll();
            }
        }
    }

    private static void bfs() {
        visited = new boolean[12][6];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.' || visited[i][j]) continue;

                q.offer(new int[]{i, j});
                visited[i][j] = true;

                list = new ArrayList<>();
                list.add(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = now[0] + dx[d];
                        int ny = now[1] + dy[d];

                        if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                        if (visited[nx][ny]) continue;
                        if (map[nx][ny] != map[now[0]][now[1]]) continue;

                        q.offer(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

                if (list.size() >= 4) {
                    check = true;

                    for (int k = 0; k < list.size(); k++) {
                        map[list.get(k)[0]][list.get(k)[1]] = '.';
                    }
                }
            }
        }
    }

    static class Data {
        int x, y;
        char color;

        public Data(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
