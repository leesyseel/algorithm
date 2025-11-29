import java.util.*;
import java.io.*;

class Main{
    static int res, N;
    static int[][] board;
    static boolean[] visited;
    
    static void DFS(int now, int sum, int cnt){
        if(sum > res) return;
        if(cnt == N){
            res = Math.min(res, sum);
            return;
        }
        
        visited[now] = true;
        for(int i = 0; i < N; i++){
            if(!visited[i]) DFS(i, sum + board[now][i], cnt + 1);
        }
        visited[now] = false;
    }
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    stk = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(stk.nextToken());
	    int K = Integer.parseInt(stk.nextToken());
	    
	    board = new int[N][N];
	    for(int i = 0; i < N; i++){
	        stk = new StringTokenizer(br.readLine());
	        for(int j = 0; j < N; j++){
	            board[i][j] = Integer.parseInt(stk.nextToken());
	        }
	    }
	    
	    for(int k = 0; k < N; k++){
	        for(int i = 0; i < N; i++){
	            for(int j = 0; j < N; j++){
	                board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
	            }
	        }
	    }
	    
	    visited = new boolean[N];
	    res = Integer.MAX_VALUE;
	    DFS(K, 0, 1);
	    System.out.println(res);
	}
}
