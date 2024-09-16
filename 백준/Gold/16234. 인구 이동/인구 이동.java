
import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static boolean[][] visit;
	static int N, L, R;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static boolean isOut(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) return true;
		return false;
	}

	static boolean scope(int r, int c, int nr, int nc) {
		int tmp = Math.abs(map[r][c] - map[nr][nc]);
		if (tmp >= L && tmp <= R) return true;
		return false;
	}

	static boolean BFS(int r, int c) {

		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        
        List<Point> union = new ArrayList<>();
		int cnt = 0, sum = 0;
		Queue<Point> Q = new ArrayDeque<>();
        
		Point sP = new Point(r, c);
		Q.add(sP);
		visit[r][c] = true;

		while (!Q.isEmpty()) {

			Point P = Q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = P.r + delta[d][0];
				int nc = P.c + delta[d][1];

				if (isOut(nr, nc) || visit[nr][nc] || !scope(P.r, P.c, nr, nc)) continue;

				Point tP = new Point(nr, nc);
				Q.add(tP);
				visit[nr][nc] = true;
				union.add(tP);
				cnt++;
				sum += map[nr][nc];
			}
		}
		if (union.size() != 0) {
			union.add(sP);
			cnt++;
			sum += map[r][c];

			int popul = sum / cnt;
			for (Point P : union) {
				map[P.r][P.c] = popul;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		L = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		int time = 0;

		while (true) {
			boolean flag = true;
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j]) continue;

					if (BFS(i, j)) flag = false;
				}
			}

			if (flag) break;
			time++;
		}
		System.out.println(time);
	}
}
