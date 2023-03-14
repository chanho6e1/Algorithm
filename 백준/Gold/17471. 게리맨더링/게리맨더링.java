import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, people[], res = Integer.MAX_VALUE;
    static ArrayList<Integer>[] list;
    static boolean[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 구역 개수
        people = new int[N+1]; // 구역 인구

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        A = new boolean[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++){
                int a = Integer.parseInt(st.nextToken());
                list[i].add(a);
            }
        }

        Subset(1);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    public static void Subset(int idx){
        if(idx == N+1){
            if(bfs()){
                int sumA = 0, sumB = 0;
                for(int i=1; i<=N; i++){
                    if(A[i]) sumA += people[i];
                    else sumB += people[i];
                }

                res = Math.min(res, Math.abs(sumA - sumB));
            }

            return;
        }

        A[idx] = true;
        Subset(idx+1);
        A[idx] = false;
        Subset(idx+1);
    }

    public static boolean bfs(){
        int a = -1;
        int b = -1;

        for(int i=1; i<=N; i++){
            if(A[i]){
                a = i;
                break;
            }
        }

        for(int i=1; i<=N; i++){
            if(!A[i]){
                b = i;
                break;
            }
        }

        if(a==-1 || b==-1) return false;

        boolean[] visited = new boolean[N+1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        visited[a] = true;
        while(!q.isEmpty()){
            int now = q.poll();

            for(Integer i : list[now]){
                if(visited[i]) continue;
                if(!A[i]) continue;
                visited[i] = true;
                q.offer(i);
            }
        }

        q.offer(b);
        visited[b] = true;
        while(!q.isEmpty()){
            int now = q.poll();

            for(Integer i : list[now]){
                if(visited[i]) continue;
                if(A[i]) continue;
                visited[i] = true;
                q.offer(i);
            }
        }

        for(int i=1; i<=N; i++)
            if(!visited[i]) return false;

        return true;
    }
}
