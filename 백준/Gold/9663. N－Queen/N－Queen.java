import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, res;
    static int[] cols;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cols = new int[N+1];

        dfs(1);

        System.out.println(res);
    }

    private static void dfs(int idx){
        if(!isPossible(idx-1)) return;

        if(idx==N+1){
            res++;
            return;
        }

        for(int i=1; i<=N; i++){
            cols[idx] = i;

            if(!isPossible(idx-1)) continue;

            dfs(idx+1);
        }
    }

    private static boolean isPossible(int num){

        for(int i=1; i<num; i++){

            if(cols[i]==cols[num]) // 같은 행에 존재할 경우
                return false;
            if(Math.abs(i-num) == Math.abs(cols[i]-cols[num])) // 대각선에 존재할 경우
                return false;
        }

        return true;
    }
}
