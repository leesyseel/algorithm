import java.io.*;
import java.util.*;

public class Main {
	static int K, W, H;

	static class Point {
		int r, c, leftK;

		public Point(int r, int c, int leftK) {
			super();
			this.r = r;
			this.c = c;
			this.leftK = leftK;
		}
	}

	static boolean isInbound(int r, int c) {
		if (r >= 0 && r < H && c >= 0 && c < W)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		K = Integer.parseInt(br.readLine());

		stk = new StringTokenizer(br.readLine());
		W = Integer.parseInt(stk.nextToken());
		H = Integer.parseInt(stk.nextToken());
		int[][] map = new int[H][W];

		for (int i = 0; i < H; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		int[][][] res = new int[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(res[i][j], Integer.MAX_VALUE);
			}
		}

		Queue<Point> Q = new ArrayDeque<>();
		Q.add(new Point(0, 0, K));
		res[0][0][K] = 0;

		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int[][] horse = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };

		while (!Q.isEmpty()) {

			Point P = Q.poll();
			int r = P.r;
			int c = P.c;
			int lk = P.leftK;

			int nr, nc;
			for (int d = 0; d < 4; d++) {
				nr = r + delta[d][0];
				nc = c + delta[d][1];

				if (isInbound(nr, nc) && map[nr][nc] == 0 && res[nr][nc][lk] > res[r][c][lk] + 1) {
					res[nr][nc][lk] = res[r][c][lk] + 1;
					Q.add(new Point(nr, nc, lk));
				}
			}

			for (int h = 0; h < 8; h++) {
				nr = r + horse[h][0];
				nc = c + horse[h][1];

				if (isInbound(nr, nc) && map[nr][nc] == 0 && lk - 1 >= 0 && res[nr][nc][lk - 1] > res[r][c][lk] + 1) {
					res[nr][nc][lk - 1] = res[r][c][lk] + 1;
					Q.add(new Point(nr, nc, lk - 1));
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			min = Math.min(min, res[H - 1][W - 1][i]);
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
