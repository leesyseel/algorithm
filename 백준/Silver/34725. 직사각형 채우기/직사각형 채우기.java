import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk = new StringTokenizer(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(stk.nextToken());
	    int M = Integer.parseInt(stk.nextToken());
	    int K = (N * M) / 4;
	    
	    int[][] res = new int[N][M];
	    int num = 1;
	    for(int c = 0; c < N / 2; c++){
	        for(int i = 0; i < M / 2; i++){
	            res[c][i] = res[c][M - 1 - i] = res[N - 1 - c][i] = res[N - 1 - c][M - 1 - i] = num++;
	        }
	    }
	    
	    for(int i = 0; i < N; i++){
	        for(int j = 0; j < M; j++){
	            sb.append(res[i][j]+" ");
	        }
	        sb.append("\n");
	    }
	    System.out.println(sb);
	}
}
