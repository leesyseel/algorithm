
import java.util.*;
import java.io.*;

public class Main {

	static void BFS(int i, int j, int[][] map, boolean[][] check) {
		int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int std = map[i][j];
		Queue<int[]> Q = new ArrayDeque<>();
		Q.add(new int[] { i, j });
		check[i][j]=true;

		while (!Q.isEmpty()) {
			int[] tmp = Q.poll();
			int r = tmp[0], c = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];

				if (!check[nr][nc] && map[nr][nc] == std) {
					check[nr][nc] = true;
					Q.add(new int[] { nr, nc });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] map_no = new int[N + 2][N + 2];
		int[][] map_yes = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				map_no[i][j] = s.charAt(j - 1) - 'A';
				map_yes[i][j] = s.charAt(j - 1) - 'A';
				if (map_yes[i][j] == 6)
					map_yes[i][j] = 17;
			}
		}

		boolean[][] check_no = new boolean[N + 2][N + 2];
		boolean[][] check_yes = new boolean[N + 2][N + 2];
		int no = 0, yes = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!check_no[i][j]) {
					BFS(i, j, map_no, check_no);
					no++;
				}
				if (!check_yes[i][j]) {
					BFS(i, j, map_yes, check_yes);
					yes++;
				}
			}
		}

		sb.append(no).append(" ").append(yes);
		System.out.println(sb);
	}
}
