import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        
        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int l = map[i][j];
                if(l == 0) break;
                
                if(i + l < N){
                    dp[i + l][j] += dp[i][j];
                }
                if(j + l < N){
                    dp[i][j + l] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}