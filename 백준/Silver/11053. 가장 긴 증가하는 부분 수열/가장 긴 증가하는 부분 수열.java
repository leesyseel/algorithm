import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int N = Integer.parseInt(br.readLine());

		stk = new StringTokenizer(br.readLine());
		int[] arr=new int[N];
		int[] dp=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(stk.nextToken());
		}
		
		Arrays.fill(dp, 1);
		for(int now=1;now<N;now++){
            for(int j=0;j<now;j++) {
            	if(arr[now]>arr[j]&&dp[j]+1>dp[now])
            		dp[now]++;
            }
        }
		
		int max=0;
		for(int i=0;i<N;i++) {
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}