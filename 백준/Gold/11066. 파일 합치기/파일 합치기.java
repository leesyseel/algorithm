import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int INF = 100000000;
		
		while(T-- > 0){
		    int N = Integer.parseInt(br.readLine());
		    StringTokenizer stk  = new StringTokenizer(br.readLine());
		    int[] arr = new int[N + 1];
		    int[][] dp = new int[N + 1][N + 1];
		    
		    for(int i = 1; i <= N; i++){
		        arr[i] = arr[i - 1] + Integer.parseInt(stk.nextToken());
		        Arrays.fill(dp[i], INF);
		        dp[i][i] = 0;
		    }
		    
		    for(int gap = 1; gap < N; gap++){
		        for(int s = 1; s + gap <= N; s++){
		            int e = s + gap;
		            for(int i = s; i < e; i++){
		                dp[s][e] = Math.min(dp[s][e], dp[s][i] + dp[i + 1][e] + arr[e] - arr[s - 1]);
		            }
		        }
		    }
		    sb.append(dp[1][N] + "\n");
		}
        System.out.println(sb);
	}
}
