import java.io.*;
import java.util.*;

public class Main {
	static int minVirus;
	static int[][] map;
	static List<Virus> vList;
	
	static class Virus{
		int r,c;
		
		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static void DFS(int cnt, int N,int M) {
		
		if(cnt==3) {
			spread(N,M);
			
		}else {
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {

					if(map[i][j]==0) {
						map[i][j]=1;
						DFS(cnt+1,N,M);
						map[i][j]=0;
					}
				}
			}
		}
	}
	
	static void spread(int N, int M) {
		
		int[][] tmp = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[i][j]=map[i][j];		
			}
		}
		
		int[][] deltas= {{-1,0},{0,1},{1,0},{0,-1}};
		Queue<Virus> Q = new ArrayDeque<Virus>();
		
		for(Virus V : vList) {
			Q.add(V);
		}
		
		int virusCnt=0;
		while(!Q.isEmpty()) {
			
			Virus curl = Q.poll();
			virusCnt++;
			
			for(int d=0;d<4;d++) {
				int nr=curl.r+deltas[d][0];
				int nc=curl.c+deltas[d][1];
				
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&tmp[nr][nc]==0) {
					tmp[nr][nc]=2;
					Q.add(new Virus(nr, nc));
				}
			}
		}
		
		minVirus = Math.min(minVirus, virusCnt);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		map=new int[N][M];
		vList = new ArrayList<>();
		int wallCnt=0;
		
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
				if(map[i][j]==2) vList.add(new Virus(i,j));
				if(map[i][j]==1) wallCnt++;
			}
		}

		minVirus=Integer.MAX_VALUE;
		DFS(0,N,M);
		
		System.out.println(N*M-minVirus-wallCnt-3);
		
	}
}
