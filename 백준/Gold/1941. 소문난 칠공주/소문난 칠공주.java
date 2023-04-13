import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] map;
    static int[] arr;
    static boolean[] visited;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        for(int i=0; i<5; i++)
            map[i] = br.readLine().toCharArray();

        arr = new int[7];
        visited = new boolean[25];

        Comb(0, 0);

        System.out.println(res);
    }

    private static void Comb(int start, int idx) {
        if(idx == 7){
            if(bfs()) res++;
            return;
        }

        for(int i=start; i<25; i++){
            if(visited[i]) continue;
            arr[idx] = i;
            visited[i] = true;
            Comb(i+1, idx+1);
            visited[i] = false;
        }
    }

    private static boolean bfs() {
        int Y = 0;
        for(int i: arr){
            if(map[i/5][i%5] == 'Y') Y++;
        }

        if(Y>3) return false;

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i:arr) temp.add(i);

        Queue<Integer> q = new LinkedList<>();
        q.offer(arr[0]);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now/5 + dx[i];
                int ny = now%5 + dy[i];

                if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;
                if(temp.contains(nx*5 + ny)){
                    temp.remove(Integer.valueOf(nx*5 + ny));
                    q.offer(nx*5 + ny);
                }
            }
        }

        if(!temp.isEmpty()) return false;

        return true;
    }
}
