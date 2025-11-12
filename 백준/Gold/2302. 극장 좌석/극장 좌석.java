import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    boolean[] check = new boolean[N + 1];
	    int M = Integer.parseInt(br.readLine());
	    for(int i = 0; i < M; i++){
	        check[Integer.parseInt(br.readLine())] = true;
	    }
	    
	    int[] dp = new int[N + 1];
	    dp[0] = dp[1] = 1;
	    if(check[1]){
	        dp[0] = 0; 
	    }
	    
	    
	    int res = 1;
	    for(int i = 2; i <= N; i++){
	        if(check[i]){
	            res *= dp[i - 1];
	            dp[i - 1] = 0; 
	            dp[i] = 1;
	            continue;
	        }
	        dp[i] = dp[i - 2] + dp[i - 1];
	    }
	    
	    res *= dp[N];
	    System.out.println(res);
	}
}
