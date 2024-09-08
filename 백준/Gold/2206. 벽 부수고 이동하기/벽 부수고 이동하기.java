import java.io.*;
import java.util.*;

public class Main {
	static int N, M;

	static class Point {
		int r, c, x;

		public Point(int r, int c, int x) {
			super();
			this.r = r;
			this.c = c;
			this.x = x;
		}
	}

	static boolean isOut(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int[][][] dp = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}

		dp[0][0][1] = 1;
		Queue<Point> Q = new ArrayDeque<>();
		Q.add(new Point(0, 0, 1));

		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		while (!Q.isEmpty()) {
			Point P = Q.poll();
			int r = P.r;
			int c = P.c;
			int x = P.x;

			for (int d = 0; d < 4; d++) {

				int nr = r + delta[d][0];
				int nc = c + delta[d][1];

				if (isOut(nr, nc))
					continue;

				if (map[nr][nc] == 0 && dp[nr][nc][x] > dp[r][c][x] + 1) {
					dp[nr][nc][x] = dp[r][c][x] + 1;
					Q.add(new Point(nr, nc, x));
				}

				if (x == 1 && map[nr][nc] == 1 && dp[nr][nc][x - 1] > dp[r][c][x] + 1) {
					dp[nr][nc][x - 1] = dp[r][c][x] + 1;
					Q.add(new Point(nr, nc, x - 1));
				}
			}
		}
		int res = Math.min(dp[N - 1][M - 1][0], dp[N - 1][M - 1][1]);
		if (res == Integer.MAX_VALUE)
			res = -1;

		System.out.println(res);
	}
}