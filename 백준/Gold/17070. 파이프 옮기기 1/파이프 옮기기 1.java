import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 2][N + 2];
		int[][][] pipe = new int[N + 2][N + 2][3];

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		pipe[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {

				if (map[i][j] == 1) continue;
				pipe[i][j][0] = pipe[i][j - 1][0] + pipe[i][j - 1][2];
				pipe[i][j][1] = pipe[i - 1][j][1] + pipe[i - 1][j][2];

				if (map[i - 1][j] == 1 || map[i][j - 1] == 1) continue;
				pipe[i][j][2] = pipe[i - 1][j - 1][0] + pipe[i - 1][j - 1][1] + pipe[i - 1][j - 1][2];
			}
		}
		
		int res=0;
		for(int i=0;i<3;i++) {
			res+=pipe[N][N][i];
		}
		System.out.println(res);
	}
}