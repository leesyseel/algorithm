import java.io.*;

public class Main {

	static int N, target;
	static boolean[][] check;

	public static boolean DFS(int[] nums, int pick) {
		if (pick == target) {
			// 모두 연결되었는지 확인
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!check[i][j])
						return false;
				}
			}
			return true;

		} else {
			int last = nums[pick];
			for (int i = 1; i <= N; i++) {
				if (check[last][i])
					continue;

				check[last][i] = check[i][last] = true;
				nums[pick + 1] = i;
				if (DFS(nums, pick + 1))
					return true;
				check[last][i] = check[i][last] = false;
			}
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		target = N * (N - 1) / 2 + 1;
		check = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			check[i][i] = true;
		}

		int[] nums = new int[target + 1];
		nums[1] = 1;
		DFS(nums, 1);

		for (int i = 1; i <= target; i++) {
			sb.append("a").append(nums[i]).append(" ");
		}
		System.out.println(sb);
	}
}