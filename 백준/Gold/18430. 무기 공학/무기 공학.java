import java.util.*;
import java.io.*;

class Main{
    static int N, M, res;
    static int[][] board;
    static int[][] dx = {{0, -1, 1, 0}, {0, -1, -1, 0}, {-1, 0, 0, 1}, {1, 0, 0, 1}};
    static boolean[][] check;
    
    static void solve(int idx, int sum){
        
        if(idx == N * M){
            res = Math.max(res, sum);
            return;
        }
        
        int sr = idx / M;
        int sc = idx % M;
        
        solve(idx + 1, sum);
        if(check[sr][sc]){
            return;
        }
        check[sr][sc] = true;
                
        for(int d = 0; d< 4; d++){
            int r1 = sr + dx[d][0];
            int c1 = sc + dx[d][1];
            int r2 = sr + dx[d][2];
            int c2 = sc + dx[d][3];
                    
            if(r1 < 0 || r1 >= N || c1 < 0 | c1 >= M || r2 < 0 || r2 >= N || c2 < 0 || c2 >= M || check[r1][c1] || check[r2][c2]) continue;
                    
            int tmp = board[sr][sc] * 2 + board[r1][c1] + board[r2][c2];
            check[r1][c1] = check[r2][c2] = true;
            solve(idx + 1, sum + tmp);
            check[r1][c1] = check[r2][c2] = false;
        }
        check[sr][sc] = false;
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

        board = new int[N][M];
        check = new boolean[N][M];
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        
        res = 0;
        solve(0, 0);
        System.out.println(res);
	}
}
