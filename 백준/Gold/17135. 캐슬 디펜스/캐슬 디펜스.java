
import java.util.*;
import java.io.*;

public class Main {
	static int result;
	static int N, M, D;
	static int[][] map;
	static int[][] tmp;

	static void pick(int idx, int pnum, int[] person) {

		if (pnum > 3)
			return;

		if (idx == M) {
			if (pnum == 3) {
				// 쏠 수 있는 병사 수 구하는 함수 호출

				tmp = new int[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						tmp[i][j] = map[i][j];
					}
				}
				count(person);
			}
		} else {
			person[idx] = 1;
			pick(idx + 1, pnum + 1, person);
			person[idx] = 0;
			pick(idx + 1, pnum, person);
		}
	}

	static void count(int[] person) {

		for (int r = N; r > 0; r--) {

			List<int[]> kill = new ArrayList<>();

			for (int c = 0; c < M; c++) {
				if (person[c] == 1) {
					// 궁수의 위치가 r,c일 때 가장 가까운 병사 찾기
					int[] arr = BFS(r, c);
					if (arr != null) {
						kill.add(arr);
					}
				}
			}

			for (int i = 0; i < kill.size(); i++) {
				int[] arr = kill.get(i);
				tmp[arr[0]][arr[1]] = 2;
			}
		} //활 쏘기 종료
        
        //화살 맞은 병사 count
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmp[i][j] == 2)
					cnt++;
			}
		}

		result = Math.max(result, cnt);
	}

	static int[] BFS(int ar, int ac) {

		boolean[][] visit = new boolean[N][M];

		int[][] deltas = { { 0, -1 }, { -1, 0 }, { 0, 1 } };
		Queue<int[]> Q = new ArrayDeque<>();

		Q.add(new int[] { ar, ac });

		while (!Q.isEmpty()) {

			int[] arr = Q.poll();
			int r = arr[0];
			int c = arr[1];

			for (int d = 0; d < 3; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];

				if (nr == ar)
					continue;

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visit[nr][nc]
						&& Math.abs(ar - nr) + Math.abs(ac - nc) <= D) {
					if (tmp[nr][nc] == 1) {
						return new int[] { nr, nc };
					}
					Q.add(new int[] { nr, nc });
					visit[nr][nc] = true;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		result = 0;
		int[] person = new int[M];
		pick(0, 0, person);

		System.out.println(result);
	}
}