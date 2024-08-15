import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer stk;
		
		stk= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[][] map= new int[N][N];
		
		for(int i=0;i<N;i++) {
			stk= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp= Integer.parseInt(stk.nextToken());
				
				if(i==0&&j==0) map[i][j]=tmp;
				else if(i==0&j!=0) map[i][j]=map[i][j-1]+tmp;
				else if(i!=0&j==0) map[i][j]=map[i-1][j]+tmp;
				else map[i][j]=map[i-1][j]+map[i][j-1]+tmp-map[i-1][j-1];
			}
		}
		
		while(M-->0) {
			stk= new StringTokenizer(br.readLine());
			int sr=Integer.parseInt(stk.nextToken())-1;
			int sc=Integer.parseInt(stk.nextToken())-1;
			int er=Integer.parseInt(stk.nextToken())-1;
			int ec=Integer.parseInt(stk.nextToken())-1;
			
			int result=map[er][ec];
			
			if(sr-1>=0) result-=map[sr-1][ec];
			if(sc-1>=0) result-=map[er][sc-1];
			if(sr-1>=0&&sc-1>=0) result+=map[sr-1][sc-1];
			
			
			sb.append(result+"\n");
			
		}

		
		System.out.println(sb);
	}

}