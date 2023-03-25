import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시의 수

        parent = new int[N+1];
        for(int i=1; i<N+1; i++)
            parent[i] = i;

        for (int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<N+1; j++){
                if(st.nextToken().equals("1")) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i=0; i<M-1; i++){
            if(start != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static void union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if(pA == pB) return;

        if(pA > pB) parent[pB] = pA;
        else parent[pA] = pB;
    }

    private static int find(int num){
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
}
