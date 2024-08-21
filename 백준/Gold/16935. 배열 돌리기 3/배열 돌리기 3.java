import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] flip_updown(int[][] map) {
		int N = map.length;
		for (int i = 0; i < N / 2; i++) {
			int[] temp_arr = map[i];
			map[i] = map[N - 1 - i];
			map[N - 1 - i] = temp_arr;
		}
		return map;
	}

	static int[][] flip_ltrt(int[][] map) {
		int M = map[0].length;
		int N = map.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = map[i][j];
				map[i][j] = map[i][M - 1 - j];
				map[i][M - 1 - j] = tmp;
			}
		}
		return map;
	}

	static int[][] spin_right(int[][] map) {
		int N = map.length;
		int M = map[0].length;

		int[][] tmp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[j][N - 1 - i] = map[i][j];
			}
		}

		return tmp;
	}

	static int[][] spin_left(int[][] map) {
		int N = map.length;
		int M = map[0].length;

		int[][] tmp = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[M - 1 - j][i] = map[i][j];
			}
		}

		return tmp;
	}

	static int[][] div_right(int[][] map) {

		int N = map.length;
		int M = map[0].length;

		int divN = N / 2;
		int divM = M / 2;
		
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (i >= 0 && i < divN && j >= 0 && j < divM)
					tmp[i][j + divM] = map[i][j];
				else if (i >= 0 && i < divN && j >= divM && j < M)
					tmp[i + divN][j] = map[i][j];
				else if (i >= divN && i < N && j >= 0 && j < divM)
					tmp[i - divN][j] = map[i][j];
				else
					tmp[i][j - divM] = map[i][j];
			}
		}
		
		return tmp;
	}

	static int[][] div_left(int[][] map) {
		int N = map.length;
		int M = map[0].length;

		int divN = N / 2;
		int divM = M / 2;

		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (i >= 0 && i < divN && j >= 0 && j < divM)
					tmp[i + divN][j] = map[i][j];
				else if (i >= 0 && i < divN && j >= divM && j < M)
					tmp[i][j - divM] = map[i][j];
				else if (i >= divN && i < N && j >= 0 && j < divM)
					tmp[i][j + divM] = map[i][j];
				else
					tmp[i - divN][j] = map[i][j];
			}
		}

		return tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		//int[] oper = new int[R];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int oper = Integer.parseInt(stk.nextToken());
			
			switch (oper) {
			case 1:
				map = flip_updown(map);
				break;
			case 2:
				map = flip_ltrt(map);
				break;
			case 3:
				map = spin_right(map);
				break;
			case 4:
				map = spin_left(map);
				break;
			case 5:
				map = div_right(map);
				break;
			case 6:
				map = div_left(map);
				break;

			}
		}

		//int[][] result = null;

		

		N = map.length;
		M = map[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}