import java.util.*;
import java.io.*;

class Main{
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        
        int[] coin = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < N; i++){
            for(int j = coin[i]; j <= K; j++){
                if(dp[j - coin[i]] == Integer.MAX_VALUE){
                    continue;
                }
                dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
            }
        }
        if(dp[K] == Integer.MAX_VALUE){
            dp[K] = -1;
        }
        System.out.println(dp[K]);
	}
}
