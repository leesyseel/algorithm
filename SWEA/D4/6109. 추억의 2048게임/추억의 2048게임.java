import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static void up(int N, int[][] map) {
		
		for (int c = 1; c <= N; c++) {
			int now = 1, next = 2;
			while (next <= N) {
				if (map[now][c] == 0 && map[next][c] == 0) {
					next++;
				} else if (map[now][c] == 0 && map[next][c] != 0) {
					
					if (map[next][c] == map[next + 1][c]) {
						map[now][c] = map[next][c]*2;
						map[next][c] = 0;
						map[next + 1][c] = 0;
						now++;
						next += 2;
					} else {
						map[now][c] = map[next][c];
						map[next][c] = 0;
						next++;
					}
					
				} else if (map[now][c] != 0 && map[next][c] != 0) {
					
					if (map[now][c] == map[next][c]) {
						map[now][c] *= 2;
						map[next][c] = 0;
					}
					now++;
					if(now==next) next++;
				} else {
					next++;
				} //if-else end
				
			} //while end
		} //for end
	} // up end

	static void down(int N, int[][] map) {
		
		for (int c = 1; c <= N; c++) {
			int now = N, next = N-1;
			while (next > 0) {
				if (map[now][c] == 0 && map[next][c] == 0) {
					next--;
				} else if (map[now][c] == 0 && map[next][c] != 0) {
					
					if (map[next][c] == map[next - 1][c]) {
						map[now][c] = map[next][c]*2;
						map[next][c] = 0;
						map[next - 1][c] = 0;
						now--;
						next -= 2;
					} else {
						map[now][c] = map[next][c];
						map[next][c] = 0;
						next--;
					}
					
				} else if (map[now][c] != 0 && map[next][c] != 0) {
					
					if (map[now][c] == map[next][c]) {
						map[now][c] *= 2;
						map[next][c] = 0;
					}
					now--;
					if(now==next) next--;
				} else {
					next--;
				} //if-else end
				
			} //while end
		} //for end
	} //down end

	static void left(int N, int[][] map) {
		
		for (int r = 1; r <= N; r++) {
			int now = 1, next = 2;
			while (next <= N) {
				if (map[r][now] == 0 && map[r][next] == 0) {
					next++;
				} else if (map[r][now] == 0 && map[r][next] != 0) {
					
					if (map[r][next] == map[r][next+1]) {
						map[r][now] = map[r][next]*2;
						map[r][next] = 0;
						map[r][next+1] = 0;
						now++;
						next += 2;
					} else {
						map[r][now] = map[r][next];
						map[r][next] = 0;
						next++;
					}
					
				} else if (map[r][now] != 0 && map[r][next] != 0) {
					
					if (map[r][now] == map[r][next]) {
						map[r][now] *= 2;
						map[r][next] = 0;
					}
					now++;
					if(now==next) next++;
				} else {
					next++;
				} //if-else end
				
			} //while end
		} //for end
	} //left end

	static void right(int N, int[][] map) {
		for (int r = 1; r <= N; r++) {
			int now = N, next = N-1;
			while (next > 0) {
				if (map[r][now] == 0 && map[r][next] == 0) {
					next--;
				} else if (map[r][now] == 0 && map[r][next] != 0) {
					
					if (map[r][next] == map[r][next-1]) {
						map[r][now] = map[r][next]*2;
						map[r][next] = 0;
						map[r][next-1] = 0;
						now--;
						next -= 2;
					} else {
						map[r][now] = map[r][next];
						map[r][next] = 0;
						next--;
					}
					
				} else if (map[r][now] != 0 && map[r][next] != 0) {
					
					if (map[r][now] == map[r][next]) {
						map[r][now] *= 2;
						map[r][next] = 0;
					}
					now--;
					if(now==next) next--;
				} else {
					next--;
				} //if-else end
				
			} //while end
		} //for end
	} //right end 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");

			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);

			int[][] map = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			switch (input[1]) {
			case "up":
				up(N, map);
				break;
			case "down":
				down(N, map);
				break;
			case "left":
				left(N, map);
				break;
			case "right":
				right(N, map);
				break;
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);

	}

}