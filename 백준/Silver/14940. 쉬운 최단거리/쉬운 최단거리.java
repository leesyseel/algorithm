import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		int[][] map = new int[N + 2][M + 2];
		int tr = 0, tc = 0;
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 2) {
					tr = i;
					tc = j;
				}
			}
		}

		int[][] result = new int[N + 2][M + 2];
		Queue<int[]> Q = new ArrayDeque<>();
		Q.add(new int[] { tr, tc });
		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		while (!Q.isEmpty()) {
			int r = Q.peek()[0];
			int c = Q.peek()[1];
			Q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				if (map[nr][nc] == 1 && result[nr][nc] == 0) {
					result[nr][nc] = result[r][c] + 1;
					Q.add(new int[] { nr, nc });
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if ((result[i][j] != 0) || (map[i][j] == 0) || map[i][j]==2) {
					sb.append(result[i][j] + " ");
				} else {
					sb.append(-1 + " ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}