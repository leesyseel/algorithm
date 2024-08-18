import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int maxCore, minLine;

	static void count(int idx, int pickcore, int pickLine, int corecnt, int N, int[][] core, int[][] map,
			int[][] deltas) {

		if ((corecnt - idx + pickcore) < maxCore)
			return;

		if (idx == corecnt) {

			if (pickcore > maxCore) {
				maxCore = pickcore;
				minLine = pickLine;
				return;
			} else if (pickcore == maxCore) {
				if (minLine > pickLine) {
					minLine = pickLine;
				}
				return;
			}

		} else {

			int r = core[idx][0];
			int c = core[idx][1];

			for (int d = 0; d < 4; d++) {
				boolean flag = false;
				int tr = r, tc = c;
				int thisLine = 0;

				while (true) {
					tr += deltas[d][0];
					tc += deltas[d][1];

					if (tr < 1 || tr > N || tc < 1 || tc > N)
						break;

					if (map[tr][tc] != 0) {
						flag = true;
						break;
					}
					map[tr][tc] = 2;
					thisLine++;
				}

				if (!flag) {
					count(idx + 1, pickcore + 1, pickLine + thisLine, corecnt, N, core, map, deltas);
				}

				while (thisLine-- > 0) {
					tr -= deltas[d][0];
					tc -= deltas[d][1];
					map[tr][tc] = 0;
				}
			}

			count(idx + 1, pickcore, pickLine, corecnt, N, core, map, deltas);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			maxCore = 0;
			minLine = Integer.MAX_VALUE;

			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N + 2][N + 2];
			int[][] core = new int[13][2];
			int c = 0;

			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
					if (map[i][j] == 1) {
						if (i != 1 && i != N && j != 1 && j != N) {
							core[c][0] = i;
							core[c++][1] = j;
						}
					}
				}
			}

			int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
			count(0, 0, 0, c, N, core, map, deltas);

			sb.append(minLine + "\n");
		}
		System.out.println(sb);

	}

}
