import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			stk = new StringTokenizer(br.readLine());
			int k=Integer.parseInt(stk.nextToken());
			int n=Integer.parseInt(stk.nextToken());
			
			long[][] dp =new long[n+1][k+1];
			dp[0][0]=1;
			
			for(int i=1;i<=n;i++) {
				for(int j=0;j<=k;j++) {
					
					if(j==0) dp[i][j]=1;
					
					else if(i==j) dp[i][j]=1;
					
					else dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				}
			}
			sb.append(dp[n][k]).append("\n");
		}
		System.out.println(sb);
	}
}