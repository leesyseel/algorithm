import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result;
	
	static void food(int idx,int cnt,int sour, int bitter,int N,int[][] ingre) {
		if(idx==N) {
			if(cnt==0) return;
			
			int t=Math.abs(sour-bitter);
			if(t<result) result=t; 
		}else {
			food(idx+1,cnt+1,sour*ingre[idx][0],bitter+ingre[idx][1],N,ingre);
			food(idx+1,cnt,sour,bitter,N,ingre);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int N = Integer.parseInt(br.readLine());
		int[][] ingre = new int[N][2];
		result=Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			ingre[i][0] = Integer.parseInt(stk.nextToken());
			ingre[i][1] = Integer.parseInt(stk.nextToken());
		}

		food(0,0,1,0,N,ingre);
		System.out.println(result);
	}
}