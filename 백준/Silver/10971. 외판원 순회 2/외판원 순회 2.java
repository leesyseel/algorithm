import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visit;
	static int[][] map;
	static int N, result;
	
	static void DFS(int from,int cnt,int sum,int start) {
		
		if(cnt==N) {
			if(map[from][start]!=0) {
				result=Math.min(result, sum+map[from][start]);
			}
		}else {
			
			for(int i=0;i<N;i++) {
				if(visit[i]) continue;
				
				if(map[from][i]!=0) {
					visit[i]=true;
					DFS(i,cnt+1,sum+map[from][i],start);
					visit[i]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		
		N = Integer.parseInt(br.readLine());

		
		map=new int[N][N];

		
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(stk.nextToken());	
			}
		}
		
		result=Integer.MAX_VALUE;
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			visit[i]=true;
			DFS(i,1,0,i);
			visit[i]=false;
		}
		
		System.out.println(result);
		
	}
}
