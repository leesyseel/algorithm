
import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int lenR, lenC;

	static class Pair implements Comparable<Pair> {

		int num, cnt;

		public Pair(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pair o) {

			if (this.cnt != o.cnt)
				return this.cnt - o.cnt;
			else
				return this.num - o.num;
		}
	}

	static void operR() {

		for (int i = 0; i < lenR; i++) {

			int[] num = new int[101];
			for (int j = 0; j < lenC; j++) {
				num[map[i][j]]++;
				map[i][j] = 0;
			}

			PriorityQueue<Pair> Q = new PriorityQueue<>();
			for (int j = 1; j <= 100; j++) {
				if (num[j] == 0)
					continue;
				Q.add(new Pair(j, num[j]));
			}

			int col = 0;
			while (!Q.isEmpty()) {

				Pair P = Q.poll();
				map[i][col++] = P.num;
				map[i][col++] = P.cnt;
			}

			lenC = Math.max(lenC, col);
		}
	}

	static void operC() {

		for (int i = 0; i < lenC; i++) {

			int[] num = new int[101];
			for (int j = 0; j < lenR; j++) {
				num[map[j][i]]++;
				map[j][i] = 0;
			}

			PriorityQueue<Pair> Q = new PriorityQueue<>();
			for (int j = 1; j <= 100; j++) {
				if (num[j] == 0)
					continue;
				Q.add(new Pair(j, num[j]));
			}

			int row = 0;
			while (!Q.isEmpty()) {

				Pair P = Q.poll();
				map[row++][i] = P.num;
				map[row++][i] = P.cnt;
			}

			lenR = Math.max(lenR, row);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stk.nextToken()) - 1;
		int c = Integer.parseInt(stk.nextToken()) - 1;
		int k = Integer.parseInt(stk.nextToken());

		map = new int[100][100];

		for (int i = 0; i < 3; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		int result = -1;
		lenR = 3;
		lenC = 3;

		int time = 0;

		while (time <= 100) {

			if (map[r][c] == k) {	
				result = time;
				break;
			}

			if (lenR >= lenC)
				operR();
			else
				operC();
			
			time++;

		}

		System.out.println(result);
	}
}
