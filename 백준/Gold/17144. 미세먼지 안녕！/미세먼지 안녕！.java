
import java.util.*;
import java.io.*;

public class Main {

	static int R, C, result;
	static int[][] map;
	static int upR, dwR;

	static void spread() {

		int[][] delta = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		int[][] tmp = new int[R][C];
		int nr, nc;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0)
					continue;

				int dust = map[i][j];
				int div = dust / 5;
				for (int d = 0; d < 4; d++) {
					nr = i + delta[d][0];
					nc = j + delta[d][1];

					if (isOut(nr, nc) || map[nr][nc] == -1)
						continue;

					dust -= div;
					tmp[nr][nc] += div;
				}
				tmp[i][j] += dust;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[i][j];
			}
		}
		map[upR][0] = -1;
		map[dwR][0] = -1;
	}

	static void upClean() {

		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int d = 0;
		int r = upR - 1, c = 0;

		result += map[r][0];
		map[r][0] = 0;

		while (true) {

			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			if (isOut(nr, nc) || nr > upR) {
				d = (d + 1) % 4;
				nr = r + delta[d][0];
				nc = c + delta[d][1];
			}

			if (nr == upR && nc == 0)
				break;

			map[r][c] = map[nr][nc];
			map[nr][nc] = 0;
			r = nr;
			c = nc;
		}
	}

	static void downClean() {

		int[][] delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		int d = 0;
		int r = dwR + 1, c = 0;

		result += map[r][0];
		map[r][0] = 0;

		while (true) {

			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			if (isOut(nr, nc) || nr < dwR) {
				d = (d + 1) % 4;
				nr = r + delta[d][0];
				nc = c + delta[d][1];
			}

			if (nr == dwR && nc == 0)
				break;

			map[r][c] = map[nr][nc];
			map[nr][nc] = 0;
			r = nr;
			c = nc;
		}
	}

	static boolean isOut(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		int T = Integer.parseInt(stk.nextToken());

		map = new int[R][C];

		int[] filter = new int[2];
		int f = 0;

		int sum = 0;

		for (int i = 0; i < R; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] > 0) {
					sum += map[i][j];
				} else if (map[i][j] == -1) {
					filter[f++] = i;
				}
			}
		}

		result = 0;
		upR = filter[0];
		dwR = filter[1];

		while (T-- > 0) {
			spread();
			upClean();
			downClean();
		}

		System.out.println(sum - result);
	}
}
