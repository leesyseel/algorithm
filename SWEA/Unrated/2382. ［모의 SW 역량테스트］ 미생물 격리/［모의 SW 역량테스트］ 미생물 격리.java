import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer stk;
		int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());

			int[][][] map = new int[N][N][2];
			for (int i = 0; i < K; i++) {
				stk = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(stk.nextToken());
				int c = Integer.parseInt(stk.nextToken());
				int n = Integer.parseInt(stk.nextToken());
				int d = Integer.parseInt(stk.nextToken())-1;

				map[r][c][0] = d;
				map[r][c][1] = n;
			}

			while (M-- > 0) {
				
				ArrayList<Integer[]>[][] after=new ArrayList[N][N];
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N ; c++) {
						after[r][c]=new ArrayList<Integer[]>();
					}
				}
				

				for (int r = 0; r < N ; r++) {
					for (int c = 0; c < N ; c++) {
						if (map[r][c][1] != 0) {
							int d = map[r][c][0];
							int nr = r + deltas[d][0];
							int nc = c + deltas[d][1];
							int tmp=map[r][c][1];

							if (nr == 0 || nr == N-1  || nc == 0 || nc == N-1 ) { // 약품 O
								
								if (d % 2 == 0) d += 1;
								else d -= 1;
								tmp = tmp / 2;
							}
							after[nr][nc].add(new Integer[] {d,tmp});
						}
					}
				}
				
				for (int r = 0; r < N ; r++) {
					for (int c = 0; c < N ; c++) {
						map[r][c][0]=0;
						map[r][c][1]=0;
						if (after[r][c].size() != 0) {
							
							int maxCnt=0, sum=0, d=0;
							
							for(int i=0;i<after[r][c].size();i++) {
								
								Integer[] arr = after[r][c].get(i);
								int dir=arr[0];
								int n=arr[1];
								
								sum+=n;
								if(n>maxCnt) {
									maxCnt=n;
									d=dir;
								}
							}
							
							map[r][c][0]=d;
							map[r][c][1]=sum;	
						}
					}
				}
			} //while end
			
			int result=0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N ; c++) {
					result+=map[r][c][1];
				}
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
}