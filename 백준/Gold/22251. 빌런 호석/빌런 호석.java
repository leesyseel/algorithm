import java.util.*;
import java.io.*;

public class Main {
	static int res;
	static int N, K, P;
	static int[] origin;
	static int[][] map;

	public static void DFS(int idx, int cng, int remain) {
		if (cng > N)
			return;

		if (idx == K) {
			if (remain == P || cng == 0)
				return;
			res++;
			return;
		}

		int from = origin[idx];

		for (int to = 0; to < 10; to++) {
			if (map[from][to] > remain)
				continue;

			DFS(idx + 1, cng * 10 + to, remain - map[from][to]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int[] sign = { 0b0111111, 0b0000110, 0b1011011, 0b1001111, 0b1100110, 0b1101101, 0b1111101, 0b0000111,
				0b1111111, 0b1101111 };

		map = new int[10][10];
		int tmp;
		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				tmp = sign[i] ^ sign[j];
				map[i][j] = map[j][i] = Integer.bitCount(tmp);
			}
		}

		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		P = Integer.parseInt(stk.nextToken());
		int X = Integer.parseInt(stk.nextToken());
		tmp = X;

		origin = new int[K];
		for (int i = 0; i < K; i++) {
			origin[K - i - 1] = X % 10;
			X = X / 10;
		}

		res = 0;
		DFS(0, 0, P);
		System.out.println(res);
	}
}