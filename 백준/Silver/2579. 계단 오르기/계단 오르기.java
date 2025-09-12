import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N + 1];
		int[] dp = new int[N + 1];
		
		
		for (int i = 1; i <= N ; i++){
		    stairs[i] = Integer.parseInt(br.readLine());
		}
		
		int res = 0;
		
		if(N == 1) res = stairs[1];
		else if(N == 1) res = stairs[1] + stairs[2];
		else{
		    dp[1] = stairs[1];
		    dp[2] = stairs[1] + stairs[2];
		    
		    for(int i = 3; i <= N; i++){
		        dp[i] = Math.max(dp[i - 2], stairs[i - 1] + dp[i - 3]) + stairs[i];
		    }
		    res = dp[N];
		}
		System.out.println(res);
	}
}
