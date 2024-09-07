import java.io.*;
import java.util.*;

public class Solution {
	static int N,K,result;
	static int[][] map;
	static boolean[][] visit;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	
	static void DFS(int r, int c, int dist, int now, boolean flag) {
		
		int nr, nc;
		for(int d=0;d<4;d++) {
			nr=r+delta[d][0];
			nc=c+delta[d][1];
			
			if(visit[nr][nc]) continue;
			
			if(map[nr][nc]<now) {
				visit[nr][nc]=true;
				DFS(nr,nc,dist+1,map[nr][nc],flag);
				visit[nr][nc]=false;
			}else {
				if(flag) {
					for(int i=1;i<=K;i++) {
						if(map[nr][nc]-i<now) {
							visit[nr][nc]=true;
							DFS(nr,nc,dist+1,map[nr][nc]-i,!flag);
							visit[nr][nc]=false;
							break;
						}
					}
				}
			}
		}
		
		result=Math.max(result, dist);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			result=0;

			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			K = Integer.parseInt(stk.nextToken());
			
			visit=new boolean[N+2][N+2];
			map = new int[N + 2][N+2];
			for(int i=0;i<N+2;i++) {
				Arrays.fill(map[i], Integer.MAX_VALUE);
			}
			
			int max=0;
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					map[i][j]=Integer.parseInt(stk.nextToken());
					max=Math.max(max, map[i][j]);
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j]==max) {
						visit[i][j]=true;
						DFS(i,j,1,map[i][j],true);
						visit[i][j]=false;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
}