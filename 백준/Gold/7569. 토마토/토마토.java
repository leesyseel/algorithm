import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int day = 0;
		stk = new StringTokenizer(br.readLine());

		int col = Integer.parseInt(stk.nextToken());
		int row = Integer.parseInt(stk.nextToken());
		int height = Integer.parseInt(stk.nextToken());

		int[][][] tmt = new int[height][row][col];
		Queue<Point> Q = new LinkedList<>();

		for (int h = 0; h < height; h++) {
			for (int r = 0; r < row; r++) {
				stk = new StringTokenizer(br.readLine());
				for (int c = 0; c < col; c++) {
					tmt[h][r][c] = Integer.parseInt(stk.nextToken());
					if (tmt[h][r][c] == 1)
						Q.add(new Point(h, r, c));
				}
			}
		}

		int[][] deltas = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, -1, 0, }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, -1 } };
		int len = Q.size();
		Point P;
		while (!Q.isEmpty()) {
			if (len == 0) {
				day++;
				len = Q.size();
			}
			len--;
			P = Q.poll();
			int h = P.height, r = P.row, c = P.col;
			for (int i = 0; i < 6; i++) {
				int nh = h + deltas[i][0];
				int nr = r + deltas[i][1];
				int nc = c + deltas[i][2];
				if (nh >= 0 && nh < height && nr >= 0 && nr < row && nc >= 0 && nc < col && tmt[nh][nr][nc] == 0) {
					tmt[nh][nr][nc] = 1;
					Q.add(new Point(nh, nr, nc));
				}
			}
		}

		for (int h = 0; h < height; h++) {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (tmt[h][r][c] == 0) {
						System.out.println(-1 + "\n");
						return;
					}
				}
			}
		}

		System.out.println(day);
	}
}

class Point {
	int height;
	int row;
	int col;

	public Point(int height, int row, int col) {
		this.height = height;
		this.row = row;
		this.col = col;
	}
}
