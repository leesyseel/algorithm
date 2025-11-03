import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
		    arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i = 0; i < N; i++){
		    dp[i] = 1;
		    for(int j = 0; j < i; j++){
		        if(arr[i] > arr[j]){
		            dp[i] = Math.max(dp[i], dp[j] + 1);
		        }
		    }
		}
		
		int res = 0;
		for(int i = 0; i < N; i++){
		    res = Math.max(res, dp[i]);
		}
        System.out.println(res);
	}
}
