import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static void find_group(int row, int col, int[][] map, int M, int N) {
		int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int[][] Q = new int[M * N][2];
		int rear = 0, top = 0;

		Q[top][0] = row;
		Q[top++][1] = col;
		map[row][col]=2;

		while (rear < top) {
			int r = Q[rear][0];
			int c = Q[rear++][1];

			for (int d = 0; d < 4; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
					Q[top][0] = nr;
					Q[top++][1] = nc;
					map[nr][nc]=2;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int cnt = 0;
			stk = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(stk.nextToken());
			int N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
			int[][] map = new int[N][M];

			while (K-- > 0) {
				stk = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(stk.nextToken());
				int Y = Integer.parseInt(stk.nextToken());
				map[Y][X] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						find_group(i, j, map, M, N);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

}