import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int blue, white;
	
	static boolean color(int r, int c, int L, int[][] map) {
		int num=map[r][c];
		
		for(int i=r;i<r+L;i++) {
			for(int j=c;j<c+L;j++) {
				if(map[i][j]!=num) return false;
			}
		}
		
		if(num==1) blue+=1;
		else white+=1;
		
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb =new StringBuilder();
		StringTokenizer stk;
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		blue=0; white=0;
		
		for(int i=0;i<N;i++) {
			stk=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		
		int L=N;
		int r=0, c=0;
		Queue<int[]> Q=new ArrayDeque<>();
		Q.add(new int[] {r,c,L});
		
		while(!Q.isEmpty()) {
			r=Q.peek()[0];
			c=Q.peek()[1];
			L=Q.peek()[2];
			Q.poll();
			
			if(!color(r,c,L,map)) {
				for(int i=r;i<r+L;i+=L/2) {
					for(int j=c;j<c+L;j+=L/2) {
						Q.add(new int[] {i,j,L/2});
					}
				}
			}
		}
		
		System.out.println(white+"\n"+blue);

	}

}
