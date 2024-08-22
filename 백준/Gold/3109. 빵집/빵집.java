import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean flag;

	static void make_path(int val,int row, int col, int R, int C, int[][] map) {

		if (col == C) {
            flag=false;
			return;
		}
		if (flag&&map[row - 1][col + 1] == -1) {
			map[row - 1][col + 1] = val;
			make_path(val,row - 1, col + 1, R, C, map);
		}
        if (flag&&map[row][col + 1] == -1) {
			map[row][col + 1] = val;
			make_path(val,row, col + 1, R, C, map);
		}
        if (flag&&map[row + 1][col + 1] == -1) {
			map[row + 1][col + 1] = val;
			make_path(val,row + 1, col + 1, R, C, map);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());

		int[][] map = new int[R + 2][C + 2];
        
		for (int r = 1; r <= R; r++) {
			String[] input = br.readLine().split("");
			for (int c = 2; c <= C; c++) {
				if (input[c - 1].equals(".")) {
					map[r][c] = -1;
				}
			}
			map[r][1] = r;
		}
        
		for (int r = 1; r <= R; r++) {
            flag=true;
			make_path(r,r, 1, R, C, map);	
		}
        
		int result = 0;
		for (int r = 1; r <= R; r++) {
			if (map[r][C]!=-1)
				result++;
		}

		System.out.println(result);
	}

}