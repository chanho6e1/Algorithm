import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list = null;
	static int[] visited;
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		list = new ArrayList[n+1];
		visited = new int[n+1];

		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(list[i]);
		}

		dfs(r);
		
		for(int i=1; i<=n; i++) {
			System.out.println(visited[i]);
		}
	}

	private static void dfs(int v) {
		visited[v] = ++idx;

		for(Integer i : list[v]) {
			if(visited[i]==0) 
				dfs(i);

		}
	}

}


