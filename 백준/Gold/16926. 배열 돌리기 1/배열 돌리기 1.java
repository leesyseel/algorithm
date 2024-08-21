import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static void spin(int R,int N, int M, int[][] map) {
		int limit=Math.min(N, M)/2;
		int[][] deltas= {{0,1},{1,0},{0,-1},{-1,0}};
		
		while(R-->0){
			int cycle=0;
			while(cycle<limit) {
				int d=0;
				int r=cycle, c=cycle;
				int tmp=map[r][c];
				int nr=r+deltas[d][0], nc=c+deltas[d][1];
				
				while(true) {
					map[r][c]=map[nr][nc];
					
					r=nr; c=nc;
					nr+=deltas[d][0];
					nc+=deltas[d][1];
					
					if(nr<0+cycle||nr>=N-cycle||nc<0+cycle||nc>=M-cycle) {
						nr-=deltas[d][0];
						nc-=deltas[d][1];
						d++;
						if(d==4) break;
						nr+=deltas[d][0];
						nc+=deltas[d][1];
					}
				}
				
				map[cycle+1][cycle]=tmp;
				cycle++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer stk;

		stk=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(stk.nextToken());
		int M=Integer.parseInt(stk.nextToken());
		int R=Integer.parseInt(stk.nextToken());
		
		int[][] map=new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		spin(R,N,M,map);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}