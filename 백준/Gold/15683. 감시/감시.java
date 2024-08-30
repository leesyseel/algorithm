
import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[][] check;
	static ArrayList<Integer> cctv;
	static int result, N, M;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};

	static void DFS(int idx, int len) {
		
		if(idx==0) {
			check=new int[N][M];
		}

		if (len == idx) {
			
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(check[i][j]<0) {
						cnt++;
					}
				}
			}
			
			result=Math.max(result, cnt);
			
		} else {
			int tmp=cctv.get(idx);
			int r=tmp/10; int c=tmp%10;
			
			switch(map[r][c]) {
			case 1:
				for(int d=0;d<4;d++) {
					fill(r,c,delta[d][0],delta[d][1],1);
					DFS(idx+1, len);
					fill(r,c,delta[d][0],delta[d][1],-1);
				}
				break;
				
			case 2:
				for(int d=0;d<2;d++) {
					fill(r,c,delta[d][0],delta[d][1],2);
					fill(r,c,delta[d+2][0],delta[d+2][1],2);
					DFS(idx+1, len);
					fill(r,c,delta[d][0],delta[d][1],-2);
					fill(r,c,delta[d+2][0],delta[d+2][1],-2);
				}
				break;
				
			case 3:
				fill(r,c,delta[0][0],delta[0][1],3);
				for(int d=0;d<4;d++) {
					int dir=(d+1)%4;
					fill(r,c,delta[dir][0],delta[dir][1],3);
					DFS(idx+1, len);
					fill(r,c,delta[d][0],delta[d][1],-3);
				}
				fill(r,c,delta[0][0],delta[0][1],-3);
				break;
				
			case 4:
				fill(r,c,delta[0][0],delta[0][1],4);
				fill(r,c,delta[1][0],delta[1][1],4);
				for(int d=0;d<4;d++) {
					int dir=(d+2)%4;
					fill(r,c,delta[dir][0],delta[dir][1],4);
					DFS(idx+1, len);
					fill(r,c,delta[d][0],delta[d][1],-4);
				}
				fill(r,c,delta[0][0],delta[0][1],-4);
				fill(r,c,delta[1][0],delta[1][1],-4);
				break;
				
			case 5:
				for(int d=0;d<4;d++) {
					fill(r,c,delta[d][0],delta[d][1],5);
				}
				DFS(idx+1, len);
				for(int d=0;d<4;d++) {
					fill(r,c,delta[d][0],delta[d][1],-5);
				}
				break;
			}
		}
	}
	
	static void fill(int r, int c, int dr, int dc, int num) {
		int nr=r+dr;
		int nc=c+dc;
		
		while(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]!=6) {
			
			if(map[nr][nc]==0) {
				check[nr][nc]-=num;
			}
			nr+=dr;
			nc+=dc;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		map=new int[N][M];
		cctv = new ArrayList<>();
		int not_space=0;
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
				if(map[i][j]>0&&map[i][j]<6) {
					cctv.add(i*10+j);
				}
				if(map[i][j]!=0) not_space++;
			}
		}
		
		result=0;
		int len=cctv.size();
		if(len>0) DFS(0,len);
		
		System.out.println(N*M-result-not_space);
	}
}
