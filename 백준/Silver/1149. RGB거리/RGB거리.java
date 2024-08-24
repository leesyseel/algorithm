import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp=new int[3];
		
		stk = new StringTokenizer(br.readLine());
		for(int j=0;j<3;j++) {
			dp[j]=Integer.parseInt(stk.nextToken());
		}
		
		
		for(int i=1;i<N;i++) {

			stk = new StringTokenizer(br.readLine());
			int red=dp[0], green=dp[1], blue=dp[2];
			dp[0]=Math.min(green, blue)+Integer.parseInt(stk.nextToken());
			dp[1]=Math.min(red, blue)+Integer.parseInt(stk.nextToken());
			dp[2]=Math.min(red, green)+Integer.parseInt(stk.nextToken());
			
		}

		int result=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			result=Math.min(result, dp[i]);
		}
		System.out.println(result);
	}

}