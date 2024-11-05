import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] wine = new int[N + 3];

		for (int i = 3; i < N + 3; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N + 3];
		for (int i = 3; i < N + 3; i++) {
			dp[i] = Math.max(wine[i - 1] + dp[i - 3], dp[i - 2]) + wine[i];
			dp[i] = dp[i] > dp[i - 1] ? dp[i] : dp[i - 1];
		}

		System.out.println(dp[N + 2]);
	}
}