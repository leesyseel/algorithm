import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    
	    int n = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());
	    int INF = n * n * 100000;
	    
	    int[][] arr = new int[n][n];
	    for(int i = 0; i < n; i++){
	        Arrays.fill(arr[i], INF);
	        arr[i][i] = 0;
	    }
	    
	    for(int i = 0; i < m; i++){
	        StringTokenizer stk = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(stk.nextToken()) - 1;
	        int b = Integer.parseInt(stk.nextToken()) - 1;
	        int c = Integer.parseInt(stk.nextToken());
	        
	        if(arr[a][b] > c) arr[a][b] = c;
	    }
	    
	    for(int k = 0; k < n; k++){
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < n; j++){
	                arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
	            }
	        }
	    }
	    
	    for(int i = 0; i < n; i++){
	        for(int j = 0; j < n; j++){
	            if(arr[i][j] == INF) arr[i][j] = 0;
	            sb.append(arr[i][j] + " ");
	        }
	        sb.append("\n");
	    }
        System.out.println(sb);
	}
}