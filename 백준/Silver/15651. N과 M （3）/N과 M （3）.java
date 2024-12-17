import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static StringBuilder sb;

	static void solve(int idx, int[] arr) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= N; i++) {
				arr[idx] = i;
				solve(idx + 1, arr);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		int[] arr = new int[M];
		solve(0, arr);
		System.out.println(sb);
	}
}