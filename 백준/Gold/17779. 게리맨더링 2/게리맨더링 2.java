import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int result;
	static int total;
	static int[][] city;

	static void divArea(int idx, int[] arr) {

		if (idx == 4) {

			if (check(arr))
				return;

			// 조건 만족->구역별 인구수 구하기
			calcPopul(arr);

		} else {
			for (int i = 1; i <= N; i++) {
				arr[idx] = i;
				divArea(idx + 1, arr);
			}
		}

	}

	static boolean check(int[] arr) {

		int x = arr[0];
		int y = arr[1];
		int d1 = arr[2];
		int d2 = arr[3];

		if (x + d1 + d2 > N)
			return true;
		if (1 > y - d1 || y + d2 > N)
			return true;

		return false;
	}

	static void calcPopul(int[] arr) {

		int x = arr[0];
		int y = arr[1];
		int d1 = arr[2];
		int d2 = arr[3];

		int[] res = new int[5];

		int[][] tmp = new int[N + 2][N + 2];

		// 상좌, 하좌 경계
		for (int i = 0; i <= d1; i++) {
			tmp[x + i][y - i] = 5;
			tmp[x + d2 + i][y + d2 - i] = 5;
		}
		// 상우, 하우 경계
		for (int i = 0; i <= d2; i++) {
			tmp[x + i][y + i] = 5;
			tmp[x + d1 + i][y - d1 + i] = 5;
		}

		// 1구역
		for (int r = 1; r < x + d1; r++) {
			for (int c = 1; c <= y; c++) {
				if (tmp[r][c] != 0)
					break;
				res[0] += city[r][c];
			}
		}

		// 2구역
		for (int r = 1; r <= x + d2; r++) {
			for (int c = N; c >= y + 1; c--) {
				if (tmp[r][c] != 0)
					break;
				res[1] += city[r][c];
			}
		}

		// 3구역
		for (int r = x + d1; r <= N; r++) {
			for (int c = 1; c < y - d1 + d2; c++) {
				if (tmp[r][c] != 0)
					break;
				res[2] += city[r][c];
			}
		}
		// 4구역
		for (int r = x + d2 + 1; r <= N; r++) {
			for (int c = N; c >= y - d1 + d2; c--) {
				if (tmp[r][c] != 0)
					break;
				res[3] += city[r][c];
			}
		}
		// 5구역
		res[4] = total - (res[0] + res[1] + res[2] + res[3]);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 5; i++) {
			min = Math.min(min, res[i]);
			max = Math.max(max, res[i]);
		}

		result = Math.min(result, max - min);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		N = Integer.parseInt(br.readLine());
		city = new int[N + 2][N + 2];
		total = 0;

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(stk.nextToken());
				total += city[i][j];
			}
		}

		result = Integer.MAX_VALUE;
		int[] arr = new int[4];
		divArea(0, arr);

		System.out.println(result);
	}
}