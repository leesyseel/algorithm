import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M  = Integer.parseInt(stk.nextToken());
		
		int[] scores = new int[N + 1];
		int[] std = new int[N + 1];
		for(int i = 1; i <= N; i++){
		    stk = new StringTokenizer(br.readLine());
		    scores[i] = Integer.parseInt(stk.nextToken());
		    std[i] = Integer.parseInt(stk.nextToken());
		}
		
		int[][] dp = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++){
		    Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		for(int i = 1; i <= N; i++){
		    for(int j = 0; j <= M; j++){
		        if(j >= std[i] + 1){
		            int tmp = dp[i - 1][M - j] + scores[i];
		            dp[i][j] = dp[i][j] > tmp ? dp[i][j] : tmp;
		        }
		        else if(j == std[i]){
		            int tmp = dp[i - 1][M - j];
		            dp[i][j] = dp[i][j] > tmp ? dp[i][j] : tmp;
		        }
		        else if(dp[i - 1][M - j] != Integer.MIN_VALUE){
		            int tmp = dp[i - 1][M - j] - scores[i];
		            dp[i][j] = dp[i][j] > tmp ? dp[i][j] : tmp;
		        }
		    }
		}
		
		int max = Integer.MIN_VALUE;
		for(int j = 0; j <= M; j++){
		    max = max > dp[N][j] ? max : dp[N][j];
		}
		
		String res = "L";
		if(max > 0){
		    res = "W";
		}else if(max == 0){
		    res = "D";
		}
		System.out.println(res);
	}
}
