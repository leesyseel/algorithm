import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    stk = new StringTokenizer(br.readLine());
	    int V = Integer.parseInt(stk.nextToken());
	    int E = Integer.parseInt(stk.nextToken());
	    int MAX = 1000000000;
	    
	    int[][] arr = new int[V][V];
	    for(int i = 0; i < V; i++){
	        Arrays.fill(arr[i], MAX);
	    }
	    
	    for(int i = 0; i < E; i++){
	        stk = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(stk.nextToken()) - 1;
	        int b = Integer.parseInt(stk.nextToken()) - 1;
	        int c = Integer.parseInt(stk.nextToken());
	        
	        arr[a][b] = c;
	    }
	    
	    for(int k = 0; k < V; k++){
	        for(int i = 0; i < V; i++){
	            for(int j = 0; j < V; j++){
	                arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
	            }
	        }
	    }
	    
	    int res = MAX;
	    for(int i = 0; i < V; i++){
	        res = Math.min(res, arr[i][i]);
	    }
	    if(res == MAX) res = -1;
	    System.out.println(res);
	}
}