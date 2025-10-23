import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[][] map = new int[N][M + 2];
		int[][][] dp = new int[N][M + 2][3];
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    for(int j = 1; j <= M; j++){
		        map[i][j] = Integer.parseInt(stk.nextToken());
		    }
		}
		
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < M + 2; j++){
		       Arrays.fill(dp[i][j], 1000);
		    }
		}
		
		for(int i = 1; i <= M; i++){
		    dp[0][i][0] = dp[0][i][1] = dp[0][i][2] = map[0][i];
		}
		
		for(int i = 1; i < N; i++){
		    for(int j = 1; j <= M; j++){
		        dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
		        dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + + map[i][j];
		        dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + + map[i][j];
		    }
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 1; i <= M; i++){
		    int tmp = Math.min(dp[N - 1][i][0], dp[N - 1][i][1]);
		    tmp = Math.min(dp[N - 1][i][2], tmp);
		    res = Math.min(res, tmp);
		}
        System.out.println(res);
	}
}
