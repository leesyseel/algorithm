import java.io.*;
import java.util.*;

public class Main {
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		int tc=1;
		while(true) {
			int N=Integer.parseInt(br.readLine());
			if(N==0) break;
			sb.append("Problem ").append(tc++).append(": ");
			
			int[][] map = new int[N][N];
			for(int i=0;i<N;i++) {
				stk =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(stk.nextToken());
				}
			}
			
			int[][] res=new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(res[i], Integer.MAX_VALUE);
			}
			
			int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
			
			Queue<Point> Q = new ArrayDeque<>();
			res[0][0]=map[0][0];
			Q.add(new Point(0,0));
			
			while(!Q.isEmpty()) {
				
				Point P = Q.poll();
				int r = P.r;
				int c=P.c;
				
				for(int d=0;d<4;d++) {
					int nr=r+deltas[d][0];
					int nc=c+deltas[d][1];
					
					if(nr>=0&&nr<N&&nc>=0&&nc<N&&res[nr][nc]>res[r][c]+map[nr][nc]) {
						res[nr][nc]=res[r][c]+map[nr][nc];
						Q.add(new Point(nr,nc));
					}
				}
			}
			sb.append(res[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
