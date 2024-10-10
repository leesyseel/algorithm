import java.util.*;
import java.io.*;

public class Main {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int calcMht(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			int n = Integer.parseInt(br.readLine());

			List<Point> pList = new ArrayList<>();

			for (int i = 0; i < n + 2; i++) {
				stk = new StringTokenizer(br.readLine());
				pList.add(new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
			}

			boolean[][] path = new boolean[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					if (calcMht(pList.get(i), pList.get(j)) <= 1000) {
						path[i][j] = true;
						path[j][i] = true;
					}
				}
			}

			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						if (path[i][k] && path[k][j]) {
							path[i][j] = true;
						}
					}
				}
			}

			if (path[0][n + 1])
				sb.append("happy");
			else
				sb.append("sad");

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
