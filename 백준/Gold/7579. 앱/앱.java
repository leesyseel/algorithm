
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		StringTokenizer stk2 = new StringTokenizer(br.readLine());
		
		int[] mem=new int[N];
		int[] cost=new int[N];
		int sum=0;
		
		for(int i=0;i<N;i++) {
			mem[i]=Integer.parseInt(stk.nextToken());
			cost[i]=Integer.parseInt(stk2.nextToken());
			sum+=cost[i];
		}
		
		int[] dp=new int[sum+1];

		for(int i=0;i<N;i++) {
			int c=cost[i];
			int m=mem[i];
			
			for(int j=sum;j>=c;j--) {
				if(dp[j]<dp[j-c]+m) {
					dp[j]=dp[j-c]+m;
				}
			}
			
		}
		
		int res=0;
		for(int i=0;i<=sum;i++) {
			if(dp[i]>=M) {
				res=i;
				break;
			}
		}
		
		System.out.println(res);
	}
}
