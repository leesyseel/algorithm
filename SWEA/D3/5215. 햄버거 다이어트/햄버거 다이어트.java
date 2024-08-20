import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int result;

	static void bit_make(int idx, int check, int N, int L, int[][] ingre) {

		if (idx == N) {
			int s = 0;
			int k = 0;
			for (int i = 0; i < N; i++) {
				if ((check & 1 << i) > 0) {
					s += ingre[i][0];
					k += ingre[i][1];
				}
				if (k > L)
					return;
			}
			if (result < s)
				result = s;
		} else {
			bit_make(idx + 1, check | 1 << idx, N, L, ingre);
			bit_make(idx + 1, check, N, L, ingre);
		}
	}

	static void nonbit_make(int idx, int score, int kcal, int N, int L, int[][] ingre) {

		if (kcal > L)
			return;
		if (idx == N) {
			if (result < score)
				result = score;
		} else {
			nonbit_make(idx + 1, score + ingre[idx][0], kcal + ingre[idx][1], N, L, ingre);
			nonbit_make(idx + 1, score, kcal, N, L, ingre);
		}
	}

	static boolean nextPermutation(int N, int[] permute) {
		int i = N - 1;
		while (i > 0 && permute[i] <= permute[i - 1])
			i--;
		if (i == 0)
			return false;

		int j = N - 1;
		while (permute[i - 1] >= permute[j])
			j--;
		swap(i - 1, j, permute);

		int k = N - 1;
		while (i <= k) {
			swap(i, k, permute);
			k--;
			i++;
		}
		return true;

	}

	static void swap(int i, int j, int[] permute) {
		int tmp = permute[i];
		permute[i] = permute[j];
		permute[j] = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			result = 0;

			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());

			int[][] ingre = new int[N][2];
			int[] permute = new int[N];
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				ingre[i][0] = Integer.parseInt(stk.nextToken());
				ingre[i][1] = Integer.parseInt(stk.nextToken());
			}

			// nonbit_make(0,0,0,N,L,ingre);
			// bit_make(0, 0, N, L, ingre);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i; j++) {
					permute[j] = 0;
				}
				for (int j = i; j < N; j++) {
					permute[j] = 1;
				}

				do {
					int kcal = 0;
					int taste = 0;
					for (int j = 0; j < N; j++) {
						kcal += permute[j] * ingre[j][1];
						taste += permute[j] * ingre[j][0];
						if (kcal > L)
							break;
					}
					if (kcal <= L)
						result = Math.max(result, taste);

				} while (nextPermutation(N, permute));

			}

			sb.append(result + "\n");

		}
		System.out.println(sb);

	}

}