import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(stk.nextToken());
		int[] coin = { 1, 5, 10, 25 };
		int[] cnt = new int[4];

		for (int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(stk.nextToken());
		}

		int[][] dp = new int[X + 1][5];

		for (int i = 0; i < 4; i++) {
			int v = coin[i];
			int n = cnt[i];
			for (int j = v; j <= X; j++) {
				if (dp[j-v][i]+1>n) continue;
				
				if(j-v>0&&dp[j-v][4]==0) continue;
				
				if ( dp[j - v][4] + 1 > dp[j][4]) {
					for (int t = 0; t < 5; t++) {
						dp[j][t] = dp[j - v][t];
						if (t == i || t == 4)
							dp[j][t] += 1;
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			sb.append(dp[X][i] + " ");
		}
		sb.append("\n");
		
		System.out.println(sb);
	}
}