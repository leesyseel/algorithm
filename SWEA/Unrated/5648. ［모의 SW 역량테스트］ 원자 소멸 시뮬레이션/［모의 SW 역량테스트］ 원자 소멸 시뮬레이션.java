import java.util.*;
import java.io.*;

public class Solution {

	static class Atom {
		int x, y;
		int dir;
		int energy;

		public Atom() {
			super();
		}
	}

	static class Pair implements Comparable<Pair> {
		int t;
		int A1, A2;

		public Pair(int t, int a1, int a2) {
			super();
			this.t = t;
			A1 = a1;
			A2 = a2;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.t - o.t;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());

			Atom[] atoms = new Atom[N];

			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());

				Atom A = new Atom();

				A.x = Integer.parseInt(stk.nextToken()) * 2;
				A.y = Integer.parseInt(stk.nextToken()) * 2;
				A.dir = Integer.parseInt(stk.nextToken());
				A.energy = Integer.parseInt(stk.nextToken());

				atoms[i] = A;
			}

			Queue<Pair> Q = new PriorityQueue<>();

			int x1, y1, x2, y2, a1, a2, d1, d2;
			int tmpX, tmpY;

			for (int i = 0; i < N; i++) {

				d1 = atoms[i].dir;

				for (int j = i + 1; j < N; j++) {

					d2 = atoms[j].dir;

					int c = 1 << d1 | 1 << d2;

					if (c == 0b1001) {

						if (d1 == 3) {
							x1 = atoms[i].x;
							y1 = atoms[i].y;
							a1 = i;

							x2 = atoms[j].x;
							y2 = atoms[j].y;
							a2 = j;

						} else {
							x2 = atoms[i].x;
							y2 = atoms[i].y;
							a2 = i;

							x1 = atoms[j].x;
							y1 = atoms[j].y;
							a1 = j;
						}

						tmpX = x2 - x1;
						tmpY = y1 - y2;

						if (tmpX == tmpY && tmpX > 0) {
							Q.add(new Pair(tmpX, a1, a2));
						}

					} else if (c == 0b0011) {

						if (d1 == 1) {
							x1 = atoms[i].x;
							y1 = atoms[i].y;
							a1 = i;

							x2 = atoms[j].x;
							y2 = atoms[j].y;
							a2 = j;

						} else {
							x2 = atoms[i].x;
							y2 = atoms[i].y;
							a2 = i;

							x1 = atoms[j].x;
							y1 = atoms[j].y;
							a1 = j;
						}

						if (x1 == x2 && y1 > y2) {
							Q.add(new Pair((y1 - y2) / 2, a1, a2));
						}

					} else if (c == 0b1100) {

						if (d1 == 3) {
							x1 = atoms[i].x;
							y1 = atoms[i].y;
							a1 = i;

							x2 = atoms[j].x;
							y2 = atoms[j].y;
							a2 = j;

						} else {
							x2 = atoms[i].x;
							y2 = atoms[i].y;
							a2 = i;

							x1 = atoms[j].x;
							y1 = atoms[j].y;
							a1 = j;
						}

						if (y1 == y2 && x2 > x1) {
							Q.add(new Pair((x2 - x1) / 2, a1, a2));
						}

					} else if (c == 0b0101) {

						if (d1 == 0) {
							x1 = atoms[i].x;
							y1 = atoms[i].y;
							a1 = i;

							x2 = atoms[j].x;
							y2 = atoms[j].y;
							a2 = j;

						} else {
							x2 = atoms[i].x;
							y2 = atoms[i].y;
							a2 = i;

							x1 = atoms[j].x;
							y1 = atoms[j].y;
							a1 = j;
						}

						tmpX = x2 - x1;
						tmpY = y2 - y1;

						if (tmpX == tmpY && tmpX > 0) {
							Q.add(new Pair(tmpX, a1, a2));
						}

					} else if (c == 0b0110) {

						if (d1 == 1) {
							x1 = atoms[i].x;
							y1 = atoms[i].y;
							a1 = i;

							x2 = atoms[j].x;
							y2 = atoms[j].y;
							a2 = j;

						} else {
							x2 = atoms[i].x;
							y2 = atoms[i].y;
							a2 = i;

							x1 = atoms[j].x;
							y1 = atoms[j].y;
							a1 = j;
						}

						tmpX = x2 - x1;
						tmpY = y1 - y2;

						if (tmpX == tmpY && tmpX > 0) {
							Q.add(new Pair(tmpX, a1, a2));
						}

					} else if (c == 0b1010) {

						if (d1 == 3) {
							x1 = atoms[i].x;
							y1 = atoms[i].y;
							a1 = i;

							x2 = atoms[j].x;
							y2 = atoms[j].y;
							a2 = j;

						} else {
							x2 = atoms[i].x;
							y2 = atoms[i].y;
							a2 = i;

							x1 = atoms[j].x;
							y1 = atoms[j].y;
							a1 = j;
						}

						tmpX = x2 - x1;
						tmpY = y2 - y1;

						if (tmpX == tmpY && tmpX > 0) {
							Q.add(new Pair(tmpX, a1, a2));
						}
					}
				}
			}

			int[] time = new int[N];

			while (!Q.isEmpty()) {

				Pair P = Q.poll();
				int i = P.A1;
				int j = P.A2;
				int t = P.t;


				if ((time[i] == 0 || time[i] == t) && (time[j] == 0 || time[j] == t)) {
					time[i] = t;
					time[j] = t;
				}
			}

			int res = 0;
			for (int i = 0; i < N; i++) {
				if (time[i] != 0) {
					res += atoms[i].energy;
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
