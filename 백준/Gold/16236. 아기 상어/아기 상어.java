import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] map;
	static int baby, cnt;
	static int sr, sc;

	static class Point implements Comparable<Point> {
		int r, c, t;

		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public int compareTo(Point o) {
			if (this.t != o.t)
				return this.t - o.t;
			else if (this.r != o.r)
				return this.r - o.r;
			else
				return this.c - o.c;
		}
	}

	static int bfs() {

		int[][] delta = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
		boolean[][] visit = new boolean[N][N];

		Queue<Point> Q = new PriorityQueue<>();
		Q.add(new Point(sr, sc, 0));
		visit[sr][sc] = true;

		while (!Q.isEmpty()) {
			Point P = Q.poll();

			int r = P.r;
			int c = P.c;
			int t = P.t;

			if (map[r][c] != 0 && map[r][c] < baby) {
				cnt++;
				map[r][c] = 0;
				sr = r;
				sc = c;

				if (cnt == baby) {
					cnt = 0;
					baby++;
				}
				return t;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (map[nr][nc] > baby || visit[nr][nc])
					continue;

				visit[nr][nc] = true;
				Q.add(new Point(nr, nc, t + 1));
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 9) {
					sr = i;
					sc = j;
					map[i][j] = 0;
				}
			}
		}

		baby = 2;
		cnt = 0;
		int res = 0;

		while (true) {
			int tmp = bfs();
			if (tmp == 0)
				break;

			res += tmp;
		}
		System.out.println(res);
	}
}
