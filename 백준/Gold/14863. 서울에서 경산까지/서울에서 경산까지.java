import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        
        int[] walkT = new int[N];
        int[] walkC = new int[N];
        int[] cycleT = new int[N];
        int[] cycleC = new int[N];
        
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            walkT[i] = Integer.parseInt(stk.nextToken());
            walkC[i] = Integer.parseInt(stk.nextToken());
            cycleT[i] = Integer.parseInt(stk.nextToken());
            cycleC[i] = Integer.parseInt(stk.nextToken());
        }
        
        long[] dp = new long[K + 1];
        Arrays.fill(dp, -1L);
        dp[0] = 0;
        
        for(int i = 0; i < N; i++){
            for(int time = K; time >= 0; time--){
                dp[time] = -1L;
                if(time >= walkT[i] && dp[time - walkT[i]] != -1L){
                    dp[time] = Math.max(dp[time], dp[time - walkT[i]] + walkC[i]);
                }
                if(time >= cycleT[i] && dp[time - cycleT[i]] != -1L){
                    dp[time] = Math.max(dp[time], dp[time - cycleT[i]] + cycleC[i]);
                }
            }
        }
        
        long answer = 0;
        for (int time = 0; time <= K; time++) {
            answer = Math.max(answer, dp[time]);
        }
        System.out.println(answer);
    }
}