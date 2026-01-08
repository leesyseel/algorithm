import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int H = Integer.parseInt(stk.nextToken());

        int[][] block = new int[N + 1][M];
        for(int i = 1; i <= N; i++){
            stk = new StringTokenizer(br.readLine());
            int j = 0;
            while(stk.hasMoreTokens()){
                block[i][j++] = Integer.parseInt(stk.nextToken());
            }
        }
        
        int[][] dp = new int[N + 1][H + 1];
        dp[0][0] = 1;
        
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= H; j++){
                dp[i][j] = dp[i - 1][j];
                for(int b : block[i]){
                    if(b == 0) continue;
                    if(j - b >= 0){
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - b]) % 10_007;
                    }
                }
            }
        }
        System.out.println(dp[N][H]);
	}
}
