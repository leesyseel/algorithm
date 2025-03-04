import java.io.*;
import java.util.*;

class Main{
    
    static int N;
    static int[] origin;
    static int[][] dp;
    
    static int solve(int lt, int rt){
        if(lt >= rt) return 0;
        
        if(dp[lt][rt] != -1) return dp[lt][rt];
        
        if(origin[lt] == origin[rt]){
            return dp[lt][rt] = solve(lt + 1, rt - 1);
        }else{
            return dp[lt][rt] = Math.min(solve(lt + 1, rt) + 1, solve(lt, rt - 1) + 1);
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        origin = new int[N];
        dp = new int[N][N];
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            origin[i] = Integer.parseInt(stk.nextToken());
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(solve(0, N - 1));
    }
}
