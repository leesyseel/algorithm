import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][];
		int[][] dp = new int[N][];

		for (int i = 0; i < N; i++) {
			map[i] = new int[i + 1];
			dp[i] = new int[i + 1];
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < i + 1; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			dp[N - 1][i] = map[N - 1][i];
		}

		for (int r = N - 2; r >= 0; r--) {
			for (int i = 0; i <= r; i++) {
				dp[r][i] = dp[r + 1][i] > dp[r + 1][i + 1] ? dp[r + 1][i] : dp[r + 1][i + 1];
				dp[r][i] += map[r][i];
			}
		}

		System.out.println(dp[0][0]);
	}

}