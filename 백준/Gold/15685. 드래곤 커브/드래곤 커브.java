import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;

	static boolean check(int r, int c) {

		if (c + 1 > 100 || map[r][c + 1] != 1)
			return false;

		if (r + 1 > 100 || map[r + 1][c] != 1)
			return false;

		if (map[r + 1][c + 1] != 1)
			return false;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		map = new int[101][101];
		int[][] delta = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int g = Integer.parseInt(stk.nextToken());

			map[r][c] = 1;
			r += delta[d][0];
			c += delta[d][1];
			map[r][c] = 1;

			int[] dir = new int[1 << g];
			dir[0] = d;

			for (int i = 1; i <= g; i++) {

				int tmp = 1 << (i - 1);
				for (int j = tmp - 1; j >= 0; j--) {
					d = (dir[j] + 1) % 4;
					dir[2 * tmp - 1 - j] = d;
					r += delta[d][0];
					c += delta[d][1];
					map[r][c] = 1;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j] == 1 && check(i, j))
					result++;
			}
		}

		System.out.println(result);
	}
}