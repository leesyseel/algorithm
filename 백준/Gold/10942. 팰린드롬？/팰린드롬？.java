import java.util.*;
import java.io.*;

class Main{
    
    static int N;
    static int[] arr;
    static int[][] dp;
    
    static int isPalindrome(int lt, int rt){
        while(lt < rt){
            if(arr[lt] != arr[rt]) return 0;
            lt++; rt--;
        }
        return 1;
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[2001][2001];
		for(int i = 0; i < 2001; i++){
		    Arrays.fill(dp[i], -1);
		}
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
		    arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0){
		    stk = new StringTokenizer(br.readLine());
		    int S = Integer.parseInt(stk.nextToken()) - 1;
		    int E = Integer.parseInt(stk.nextToken()) - 1;
		    
		    if(dp[S][E] == -1){
		        dp[S][E] = isPalindrome(S, E);
		        int r = S, c = S;
		        if(dp[r][c] == 1){
		            while(++r <= --c){
		                dp[r][c] = 1;
		            }
		        }
		    }
		    sb.append(dp[S][E] + "\n");
		}
		System.out.println(sb);
	}
}
