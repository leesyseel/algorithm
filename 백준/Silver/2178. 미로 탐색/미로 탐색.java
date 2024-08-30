
import java.util.*;
import java.io.*;

public class Main {

	static void BFS(int r, int c, int N, int M, int[][] map) {
		int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		Queue<int[]> Q = new ArrayDeque<int[]>();
		Q.add(new int[] { r, c });

		while (!Q.isEmpty()) {
			int row = Q.peek()[0];
			int col = Q.poll()[1];

			for (int d = 0; d < 4; d++) {
				int nr = row + deltas[d][0];
				int nc = col + deltas[d][1];

				if (map[nr][nc] == 1) {
					map[nr][nc] += map[row][col];
					Q.add(new int[] { nr, nc });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		int[][] map = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}

		BFS(1, 1, N, M, map);
		System.out.println(map[N][M]);

	}

}
