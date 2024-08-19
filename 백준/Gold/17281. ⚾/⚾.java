import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result, N, score;
	static int[][] hit;

	static void make_order(int p, int[] order) {
		if (p == 9) {
			calc_score(order);
		} else {
			for (int i = 0; i < 9; i++) {
				if (i != 3 && order[i] == 0) {
					order[i] = p;
					make_order(p + 1, order);
					order[i] = 0;
				}
			}
		}
	}

	static void calc_score(int[] order) {
		int outcount = 0;
		int inning = 0;
		score = 0;

		int hitter = 0;

		while (inning != N) {
			int runner = 0;
			while (true) {
				int hit_result = hit[inning][order[hitter]];
				switch (hit_result) {
				case 0:
					outcount++;
					break;
				case 1:
					runner = runner << 1;
					runner = check(runner, 1);
					runner = runner | 1 << 0;
					break;
				case 2:
					runner = runner << 2;
					runner = check(runner, 2);
					runner = runner | 1 << 1;
					break;
				case 3:
					runner = runner << 3;
					runner = check(runner, 3);
					runner = runner | 1 << 2;
					break;
				case 4:
					if ((runner & 1 << 2) != 0) {
						score++;
					}
					if ((runner & 1 << 1) != 0) {
						score++;
					}
					if ((runner & 1 << 0) != 0) {
						score++;
					}
					score++;
					runner = 0;
				}

				hitter = (hitter + 1) % 9;
				if (outcount == 3) {
					inning++;
					outcount = 0;
					break;
				}
			}
		}

		if (score > result)
			result = score;
	}

	static int check(int runner, int n) {

		for (int i = 3; i < 3 + n; i++) {
			if ((runner & 1 << i) != 0) {
				score++;
				runner &= (~(1 << i));
			}
		}
		return runner;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		N = Integer.parseInt(br.readLine());
		hit = new int[N][9];
		result = 0;

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				hit[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		int[] order = new int[9];

		make_order(1, order);

		System.out.println(result);
	}

}
