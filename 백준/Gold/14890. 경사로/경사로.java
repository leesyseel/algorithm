
import java.util.*;
import java.io.*;

public class Main {

	static int N, L;

	static boolean ramp(int[] arr) {

		int h = arr[0];
		boolean[] check = new boolean[N];

		for (int i = 0; i < N; i++) {
			if (check[i] || arr[i] == h)
				continue;

			if (h == arr[i] + 1) { // 왼쪽이 높은 경우

				int st = h - 1;
				for (int j = i; j < i + L; j++) {
					if (j < 0 || j >= N || check[j] || arr[j] != st) {
						return false;
					}
					check[j] = true;
				}
				h = st;
			} else if (h + 1 == arr[i]) { // 오른쪽이 높은 경우
				int st = h;
				for (int j = i - 1; j > i - 1 - L; j--) {
					if (j < 0 || j >= N || check[j] || arr[j] != st) {
						return false;
					}
					check[j] = true;
				}
				h += 1;
			} else { // 차이가 2 이상
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		L = Integer.parseInt(stk.nextToken());

		int[][] map1 = new int[N][N];
		int[][] map2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map1[i][j] = Integer.parseInt(stk.nextToken());
				map2[j][i] = map1[i][j];
			}
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (ramp(map1[i]))
				cnt++;
			if (ramp(map2[i]))
				cnt++;
		}

		System.out.println(cnt);
	}
}
