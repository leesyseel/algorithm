import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;

	static void DFS(int idx, int check, int M, int[] arr, int N, int[] nums) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		} else {

			for (int i = 0; i < N; i++) {
				if (((check & 1 << i) == 0) && arr[idx] != nums[i]) {
					arr[idx] = nums[i];
					DFS(idx + 1, check | 1 << i, M, arr, N, nums);

				}
			}
			for (int j = idx; j < M; j++) {
				arr[j] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		sb = new StringBuilder();

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		int[] nums = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(nums);
		int[] arr = new int[M];
		DFS(0, 0, M, arr, N, nums);

		System.out.println(sb);
	}

}