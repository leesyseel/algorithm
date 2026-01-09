import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int INF = 1_000_000;
		
		int[][] arr = new int[N][M + 2];
		int[][][] dp = new int[N][M + 2][3];
		
		for(int i = 0; i < N; i++){
		    
		    for(int j = 0; j <= M + 1; j++){
		         Arrays.fill(dp[i][j], INF);
		    }
		    
		    stk = new StringTokenizer(br.readLine());
		    for(int j = 1; j <= M; j++){
		        arr[i][j] = Integer.parseInt(stk.nextToken());
		        for(int k = 0; k < 3; k++){
		            dp[0][j][k] = arr[0][j];
		        }
		    }
		}
		
		for(int i = 1; i < N; i++){
		    for(int j = 1; j <= M; j++){
		        for(int k = 0; k < 3; k++){
		            dp[i][j][k] = Math.min(dp[i - 1][j + k - 1][(k + 1) % 3], dp[i - 1][j + k - 1][(k + 2) % 3]) + arr[i][j];
		        }
		    }
		}
		
		int res = INF;
		for(int j = 1; j <= M; j++){
		    for(int k = 0; k < 3; k++){
		        res = Math.min(res, dp[N - 1][j][k]);
		    }
		}
		System.out.println(res);
	}
}
