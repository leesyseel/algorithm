import java.io.*;
import java.util.*;

public class Main {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Point>[][] room;

	static int BFS(int N) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		boolean[][] check = new boolean[N + 2][N + 2];
		boolean[][] visit = new boolean[N + 2][N + 2];
		boolean[][] able = new boolean[N + 2][N + 2];

		Queue<Point> Q = new ArrayDeque<>();
		Q.add(new Point(1, 1));
		check[1][1] = true;
		visit[1][1] = true;
		int res = 1;

		while (!Q.isEmpty()) {
			Point curl = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curl.x + dx[i];
				int ny = curl.y + dy[i];
				able[nx][ny] = true;
			}

			for (Point P : room[curl.x][curl.y]) {

				if (!check[P.x][P.y]) {
					check[P.x][P.y] = true;
					res++;
				}

				if (able[P.x][P.y] && !visit[P.x][P.y]) {
					Q.add(new Point(P.x, P.y));
					visit[P.x][P.y] = true;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = curl.x + dx[i];
				int ny = curl.y + dy[i];

				if (visit[nx][ny] || !check[nx][ny] || !able[nx][ny])	continue;

				Q.add(new Point(nx, ny));
				visit[nx][ny] = true;
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		room = new ArrayList[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				room[i][j] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			room[x][y].add(new Point(a, b));
		}
		System.out.println(BFS(N));

	}
}