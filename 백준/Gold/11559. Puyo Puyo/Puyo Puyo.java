import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean isPop = false;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;

        while (true) {
            isPop = false;

            bfs(); // 연쇄가 가능한 뿌요들 터트리기
            onFloor(); // 뿌요들을 맨 아래로 내리기

            if (!isPop)
                break;

            result++;
        }

        System.out.println(result);
    }

    private static void bfs() {
        Queue<Puyo> q = new LinkedList<>();
        boolean visited[][] = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.' || visited[i][j]) continue;

                ArrayList<int[]> list = new ArrayList<>();
                q.offer(new Puyo(i, j, map[i][j]));
                list.add(new int[]{i, j});
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    Puyo now = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = now.x + dx[d];
                        int ny = now.y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                        if (visited[nx][ny]) continue;
                        if (map[nx][ny] != now.color) continue;

                        q.offer(new Puyo(nx, ny, map[nx][ny]));
                        list.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

                if (list.size() >= 4){
                    for (int k=0; k<list.size(); k++){
                        int x = list.get(k)[0];
                        int y = list.get(k)[1];

                        map[x][y] = '.';

                        isPop = true;
                    }
                }
            }
        }
    }

    private static void onFloor() {
        for (int j=0; j<6; j++)
            down(j);
    }

    private static void down(int j) {
        Queue<Puyo> q = new LinkedList<>();
        int idx = 11;

        for (int i = 11; i>=0; i--){
            if (map[i][j] != '.'){
                q.offer(new Puyo(i, j, map[i][j]));
                map[i][j] = '.';
            }
        }

        while (!q.isEmpty()){
            Puyo now = q.poll();

            map[idx][j] = now.color;
            idx--;
        }
    }

    static class Puyo {
        int x, y;
        char color;

        Puyo(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
