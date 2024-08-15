import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static void chaining(int node,int N,int[][] map,int[] check) {
		for(int i=0;i<N;i++) {
			if(map[node][i]==1&&check[i]==0) {
				check[i]=1;
				chaining(i,N,map,check);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[][] map=new int[N][N];
		int[] check=new int[N];
		
		for(int i=0;i<M;i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken())-1;
			int b = Integer.parseInt(stk.nextToken())-1;
			map[a][b]=map[b][a]=1; 
		}
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			if(check[i]==0) {
				check[i]=1;
				cnt+=1;
				chaining(i,N,map,check);
			}
		}
		System.out.println(cnt);
	}

}
