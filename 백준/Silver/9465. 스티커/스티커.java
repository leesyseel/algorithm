import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[][] map =new int[2][N];
			for(int i=0;i<2;i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(stk.nextToken());
				}
			}
			
			int[][] dp =new int[2][N];
			
			dp[0][0]=map[0][0];
			dp[1][0]=map[1][0];
			
			if(N>1) {
				dp[0][1]=dp[1][0]+map[0][1];
				dp[1][1]=dp[0][0]+map[1][1];
				
				for(int i=2;i<N;i++) {
					
					dp[0][i]=map[0][i]+Math.max(dp[1][i-2], dp[1][i-1]);
					dp[1][i]=map[1][i]+Math.max(dp[0][i-2], dp[0][i-1]);
					
				}
			}
			
			int res = Math.max(dp[0][N-1], dp[1][N-1]);
			sb.append(res).append("\n");

		}

		System.out.println(sb);
	}
}
