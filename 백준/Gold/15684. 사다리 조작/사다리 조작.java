import java.util.*;
import java.io.*;

public class Main {

	static int N, M, H;
	static boolean[][] map;
	static int result;

	public static void dfs(int idx, int pick) {

		if (pick > result || pick > 3)
			return;

		if (isPossible()) {
			result = result > pick ? pick : result;
			return;
		}

		for (int i = idx; i < (N + 1) * (H + 1); i++) {

			int r = i / (N + 1);
			int c = i % (N + 1);

			if (r == 0 || c == 0 || c == N)
				continue;

			if (map[r][c - 1] || map[r][c] || map[r][c + 1])
				continue;

			map[r][c] = true;
			dfs(i + 1, pick + 1);
			map[r][c] = false;

		}
	}

	public static boolean isPossible() {

		for (int num = 1; num <= N; num++) {

			int loc = num;
			for (int r = 1; r <= H; r++) {

				if (map[r][loc - 1]) {
					loc--;
				} else if (map[r][loc]) {
					loc++;
				}
			}
			if (loc != num)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		H = Integer.parseInt(stk.nextToken());

		map = new boolean[H + 1][N + 1];

		while (M-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			map[a][b] = true;
		}

		result = Integer.MAX_VALUE;

		dfs(0, 0);
		result = result > 3 ? -1 : result;
		System.out.println(result);
	}
}