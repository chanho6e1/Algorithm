import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;
	
	static class Data{
		int x, y, w;

		public Data(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int N, map[][], D[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			D = new int[N][N];
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					D[i][j] = INF;
 				}
			}
			
			bfs();
			
			sb.append("Problem " + t + ": " + D[N-1][N-1] + "\n");
			t++;
		}
		
		System.out.println(sb);
		
		br.close();

	}
	
	static void bfs() {
		
		PriorityQueue<Data> q = new PriorityQueue<>((v1,v2) -> v1.w-v2.w);
		q.offer(new Data(0, 0, map[0][0]));
		D[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			Data now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				
				if(D[nx][ny] > D[now.x][now.y] + map[nx][ny]) {
					D[nx][ny] = D[now.x][now.y] + map[nx][ny];
					q.add(new Data(nx, ny, D[nx][ny]));
				}
			}
		}
	}

}
