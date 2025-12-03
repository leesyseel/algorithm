import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int INF = Integer.MAX_VALUE;
		
		stk = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    arr[i][0] = Integer.parseInt(stk.nextToken());
		    arr[i][1] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr, (o1, o2) -> {
		    if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
		    else return Integer.compare(o1[0], o2[0]);
		});
		
		int[] dp = new int[C + 100];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i = 0; i < N; i++){
		    int cost = arr[i][0];
		    int cnt = arr[i][1];
		    
		    for(int j = cnt; j <= C + 99; j++){
		        if(dp[j - cnt] != INF) {
		            dp[j] = Math.min(dp[j], dp[j - cnt] + cost);
		        }
		    }
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = C; i <= C + 99; i++){
		    min = Math.min(min, dp[i]);
		}
		
		System.out.println(min);
	}
}
