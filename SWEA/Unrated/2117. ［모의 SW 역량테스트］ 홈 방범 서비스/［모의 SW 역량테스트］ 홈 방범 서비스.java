import java.io.*;
import java.util.*;

public class Solution {
	static int N,M,result;
	static List<int []> home;
	static int[] cost;
	
	static void calc(int r, int c) {
		
		int cnt;
		for(int k=1;k<=2*N;k++) {
			cnt=0;
			for(int[] h:home) {
				int dist=Math.abs(r-h[0])+Math.abs(c-h[1]);
				if(dist<k) cnt++;
			}
			
			if(cnt*M-((k-1)*(k-1)+k*k)>=0)
				result=Math.max(result, cnt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			
			home =new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if(stk.nextToken().equals("1"))
						home.add(new int[] {i,j});
				}
			}
			
			result=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					calc(i,j);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
