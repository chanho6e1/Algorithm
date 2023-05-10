import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		int res = 0;
		
		if(n==4||n==7) {
			res = -1;
		}else if(n%5==0) {
			res = n/5;
		}else if(n%5==1 || n%5==3) {
			res = n/5+1;
		}else if(n%5==2||n%5==4) {
			res = n/5 + 2;
		}
		
		System.out.println(res);
		
	}

}