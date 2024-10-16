import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int space;
	static int result;
	static int[][] origin;

	static class Virus {
		int r, c;
		int t;

		public Virus(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static void perm(int cnt, int idx) {

		if (cnt == M) {
			spread();
		} else {
			for (int j = idx; j < N * N; j++) {
				int r = j / N;
				int c = j % N;

				if (origin[r][c] != -1)
					continue;

				origin[r][c] = 0;
				perm(cnt + 1, j + 1);
				origin[r][c] = -1;
			}
		}
	}

	public static void spread() {

		int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int remain = space;
		Queue<Virus> Q = new ArrayDeque<>();

		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// origin -3 빈 칸, -2 벽, -1 비활성 바이러스, 0 활성 바이러스
				copy[i][j] = origin[i][j];
				if (copy[i][j] == 0) {
					Q.offer(new Virus(i, j, 0));
				}
			}
		}

		while (!Q.isEmpty() && remain != 0) {

			Virus V = Q.poll();
			int r = V.r;
			int c = V.c;
			int t = V.t;

			for (int d = 0; d < 4; d++) {

				int nr = r + delta[d][0];
				int nc = c + delta[d][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || copy[nr][nc] == -2 || copy[nr][nc] >= 0)
					continue;

				if (copy[nr][nc] == -3) {
					remain--;
				}

				copy[nr][nc] = t + 1;
				Q.add(new Virus(nr, nc, t + 1));
			}
		}

		if (remain != 0)
			return;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, copy[i][j]);
			}
		}
		result = Math.min(result, max);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		origin = new int[N][N];
		space = 0;

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// origin -3 빈 칸, -2 벽, -1 비활성 바이러스
				origin[i][j] = Integer.parseInt(stk.nextToken()) - 3;
				if (origin[i][j] == -3) {
					space++;
				}
			}
		}

		result = Integer.MAX_VALUE;
		perm(0, 0);
		if (result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}
}