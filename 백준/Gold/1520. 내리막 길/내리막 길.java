import java.util.*;
import java.io.*;

class Main{
    
    static int res, N, M;
    static int[][] board, dp;
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    static int DFS(int r, int c){
        
        if(dp[r][c] >= 0) return dp[r][c];
        
        dp[r][c] = 0;
        for(int d = 0; d < 4; d++){
            int nr = r + dx[d][0];
            int nc = c + dx[d][1];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if(board[nr][nc] > board[r][c]){
                dp[r][c] += DFS(nr, nc);
            }
        }
        return dp[r][c];
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		res = 0;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		board = new int[N][M];
		dp = new int[N][M];
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    for(int j = 0; j < M; j++){
		        board[i][j] = Integer.parseInt(stk.nextToken());
		    }
		    Arrays.fill(dp[i], -1);
		}
		
		dp[0][0] = 1;
		DFS(N -1, M -1);
        System.out.println(dp[N - 1][M -1]);
	}
}
