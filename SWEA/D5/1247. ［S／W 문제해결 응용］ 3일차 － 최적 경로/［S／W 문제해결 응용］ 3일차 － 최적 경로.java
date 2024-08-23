import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int result;

	static void DFS(int x, int y, int hx, int hy, int check, int visit, int sum, int N, int[][] person) {

		if (sum > result)
			return;

		if (visit == N) {
			sum += Math.abs(x - hx) + Math.abs(y - hy);
			result = Math.min(result, sum);
		} else {
			for (int i = 0; i < N; i++) {
				if ((check & 1 << i) == 0) {
					check |= 1 << i;
					int nx = person[i][0];
					int ny = person[i][1];
					int dist = Math.abs(x - nx) + Math.abs(y - ny);
					DFS(nx, ny, hx, hy, check, visit + 1, sum + dist, N, person);
					check &= ~(1 << i);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			int[][] person = new int[N][2];

			stk = new StringTokenizer(br.readLine());
			int wx = Integer.parseInt(stk.nextToken()); // col
			int wy = Integer.parseInt(stk.nextToken()); // row
			int hx = Integer.parseInt(stk.nextToken()); // col
			int hy = Integer.parseInt(stk.nextToken()); // row

			for (int i = 0; i < N; i++) {
				person[i][0] = Integer.parseInt(stk.nextToken()); // col
				person[i][1] = Integer.parseInt(stk.nextToken()); // row
			}

			result = Integer.MAX_VALUE;
			DFS(wx, wy, hx, hy, 0, 0, 0, N, person);

			sb.append(result).append("\n");

		}
		System.out.println(sb);

	}

}