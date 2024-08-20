import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		int[][] item=new int[N][2];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			item[i][0]=Integer.parseInt(stk.nextToken());
			item[i][1]=Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(item,(o1,o2)-> o1[0]-o2[0]);
		
		int[] dp=new int[K+1];
		
		for(int i = 0;i<N;i++) {
			int w=item[i][0];
			int v=item[i][1];
			for(int j=K;j>=w;j--) {
				dp[j]=Math.max(dp[j-w]+v,dp[j]);
			}
		}
		
		System.out.println(dp[K]);
	}
}