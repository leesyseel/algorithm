import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;

	static void div_cq(int sr, int sc, int N, int[][] map) {

		boolean flag = false;
		int num = map[sr][sc];

		for (int i = sr; i < sr + N; i++) {
			for (int j = sc; j < sc + N; j++) {
				if (map[i][j] != num) {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}

		if (flag) {
			int N2 = N / 2;

			sb.append("(");
			div_cq(sr, sc, N2, map);
			div_cq(sr, sc + N2, N2, map);
			div_cq(sr + N2, sc, N2, map);
			div_cq(sr + N2, sc + N2, N2, map);
			sb.append(")");
		} else {
			sb.append(num);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		div_cq(0, 0, N, map);

		System.out.println(sb);
	}

}