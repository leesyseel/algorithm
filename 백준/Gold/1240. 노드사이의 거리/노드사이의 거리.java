import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int INF = 10_000_001;
		
		int[][] map = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++){
		    Arrays.fill(map[i], INF);
		    map[i][i] = 0;
		}
		
		for(int i = 1; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(stk.nextToken());
		    int b = Integer.parseInt(stk.nextToken());
		    int c = Integer.parseInt(stk.nextToken());
		    map[a][b] = map[b][a] = c;
		}
		
		for(int k = 1; k <= N; k++){
		    for(int i = 1; i <= N; i++){
		        for(int j = 1; j <= N; j++){
		            map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
		        }
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(stk.nextToken());
		    int b = Integer.parseInt(stk.nextToken());
		    sb.append(map[a][b] + "\n");
		}
		System.out.println(sb);

	}
}
