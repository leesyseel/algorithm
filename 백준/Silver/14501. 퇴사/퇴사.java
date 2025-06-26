import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        int[] values = new int[N];
        
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(stk.nextToken());
            values[i] = Integer.parseInt(stk.nextToken());
        }
        
        int[] dp = new int[N + 1];
        for(int i = 0; i < N; i++){
            if(i + times[i] <= N) {
                dp[i + times[i]] = dp[i + times[i]] > dp[i] + values[i] ? dp[i + times[i]] : dp[i] + values[i];
            }
            dp[i + 1] = dp[i + 1] > dp[i] ? dp[i + 1] : dp[i];
        }
        System.out.println(dp[N]);
    }
}