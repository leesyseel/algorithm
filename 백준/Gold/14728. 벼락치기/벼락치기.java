import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(stk.nextToken());
        
        int[] dp = new int[T + 1]; 
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(stk.nextToken());
            int s = Integer.parseInt(stk.nextToken());
            
            for(int j = T; j > t - 1; j--){
                dp[j] = Math.max(dp[j - t] + s, dp[j]);
            }
        }
        System.out.println(dp[T]);
    }
}