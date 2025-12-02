import java.io.*;

public class Main {

	static int[] row, col, box;
	static int[][] board;

	static boolean dfs(int r, int c) {

		if (r == 10) {
			return true;
		}

		// r행에 j부터 비어있는 가장 가까운 칸 찾기
		while (c != 10) {
			if (board[r][c] == 0)
				break;
			c++;
		}

		// r행에 빈칸이 없다면 다음 행 확인하는 dfs 호출
		if (c == 10) {
			return dfs(r + 1, 1);
		}

		// row를 기준으로 없는 숫자 채우되 col과 box도 확인
		for (int num = 1; num < 10; num++) {

			int k = ((r - 1) / 3) * 3 + ((c - 1) / 3) + 1;
			if ((row[r] & 1 << num) > 0 || (box[k] & 1 << num) > 0 || (col[c] & 1 << num) > 0)
				continue;

			board[r][c] = num;
			row[r] = row[r] | 1 << num;
			col[c] = col[c] | 1 << num;
			box[k] = box[k] | 1 << num;

			if (c + 1 == 10) {
				if (dfs(r + 1, 1))
					return true;
			} else {
				if (dfs(r, c + 1))
					return true;
			}

			board[r][c] = 0;
			row[r] = row[r] & ~(1 << num);
			col[c] = col[c] & ~(1 << num);
			box[k] = box[k] & ~(1 << num);
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		row = new int[10];
		col = new int[10];
		box = new int[10];
		board = new int[10][10];

		for (int i = 0; i < 9; i++) {
			String S = br.readLine();
			for (int j = 0; j < 9; j++) {
				int num = S.charAt(j) - '0';
				if (num == 0)
					continue;

				board[i + 1][j + 1] = num;
				row[i + 1] = row[i + 1] | 1 << num;
				col[j + 1] = col[j + 1] | 1 << num;

				int k = (i / 3) * 3 + (j / 3) + 1;
				box[k] = box[k] | 1 << num;
			}
		}

		dfs(1, 1);

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}