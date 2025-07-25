import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int M, N;
	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int BFS(int r,int c, int n) {
		int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
		
		Queue<Point> Q = new ArrayDeque<>();
		Q.add(new Point(r, c));
		map[r][c]=n;
		int res=0;
		
		
		while(!Q.isEmpty()) {
			
			Point P =Q.poll();
			res++;
			
			for(int d=0;d<4;d++) {
				int nr=P.r+deltas[d][0];
				int nc=P.c+deltas[d][1];
				
				if(nr>=0&&nr<M&&nc>=0&&nc<N&&map[nr][nc]==0) {
					Q.add(new Point(nr, nc));
					map[nr][nc]=n;
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb  = new StringBuilder();
		
		stk=new StringTokenizer(br.readLine());
		M=Integer.parseInt(stk.nextToken());
		N=Integer.parseInt(stk.nextToken());
		int K= Integer.parseInt(stk.nextToken());
		
		map=new int[M][N];
		for(int i=0;i<K;i++) {
			stk=new StringTokenizer(br.readLine());
			int lC=Integer.parseInt(stk.nextToken());
			int lR=M-Integer.parseInt(stk.nextToken());
			int rC=Integer.parseInt(stk.nextToken());
			int rR=M-Integer.parseInt(stk.nextToken());
			
			for(int r=rR;r<lR;r++) {
				for(int c=lC;c<rC;c++) {
					map[r][c]=-1;
				}
			}
		}
		
		List<Integer> zone = new ArrayList<>();
		int cnt=1;
		
		for(int r=0;r<M;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==0) {
					zone.add(BFS(r,c,cnt++));
				}
			}
		}
		
		zone.sort((o1,o2)->o1-o2);
		sb.append(zone.size()).append("\n");
		
		for(Integer num : zone) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);

	}
}
