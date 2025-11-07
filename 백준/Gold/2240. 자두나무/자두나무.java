import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer stk = new StringTokenizer(br.readLine());
	    int T = Integer.parseInt(stk.nextToken());
	    int W = Integer.parseInt(stk.nextToken());
	    int[] time =  new int[T + 1];
	    int[][][] dp = new int[T + 1][W + 1][2];
	     
	    for(int i = 1; i <= T; i++){
	        dp[i][0][0] = dp[i - 1][0][0];
	        time[i] = Integer.parseInt(br.readLine()) - 1;
	        if(time[i] == 0){
	            dp[i][0][0] += 1;
	        }
	    }
	    
	    for(int i = 1; i <= T; i++){
	        int v = time[i];
	        for(int j = 1; j <= W; j++){
	            dp[i][j][v] = Math.max(dp[i - 1][j][v], dp[i - 1][j - 1][(v + 1) % 2]) + 1;
	            dp[i][j][(v + 1) % 2] = Math.max(dp[i - 1][j - 1][v], dp[i - 1][j][(v + 1) % 2]);
	        }
	    }
	    
	    int res = 0;
	    for(int i = 0; i <= W; i++){
	        for(int j = 0; j < 2; j++){
	            res = Math.max(res, dp[T][i][j]);
	        }
	    }
        System.out.println(res);
	}
}
