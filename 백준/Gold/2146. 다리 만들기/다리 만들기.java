import java.util.*;
import java.io.*;

class Main{
    
    static int[][] board;
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;
    
    static void makeGroup(int sr, int sc, int num){
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(sr * N + sc);
        board[sr][sc] = num;
        
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            int r = tmp / N;
            int c = tmp % N;
            
            for(int d = 0; d < 4; d++){
                int nr = r + dx[d][0];
                int nc = c + dx[d][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] != 1) continue;
                Q.add(nr * N + nc);
                board[nr][nc] = num;
            }
        }
    }
    
    static int BFS(int sr, int sc){
        
        boolean[][] visited = new boolean[N][N];
        
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[] {sr, sc, 0});
        visited[sr][sc] = true;
        
        while(!Q.isEmpty()){
            int[] curl = Q.poll();
            int r = curl[0];
            int c = curl[1];
            int len = curl[2];
            
            for(int d = 0; d < 4; d++){
                int nr = r + dx[d][0];
                int nc = c + dx[d][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if(board[nr][nc] != 0){
                    if(board[nr][nc] == board[sr][sc]){
                        continue;
                    }else{
                        return len;
                    }
                }else{
                    Q.add(new int[] {nr, nc, len + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		
		for(int i = 0; i < N; i++){
		    StringTokenizer stk = new StringTokenizer(br.readLine());
		    for(int j = 0; j < N; j++){
		        board[i][j] = Integer.parseInt(stk.nextToken());
		    }
		}
		
		int cnt = 1;
		for(int i = 0; i < N;  i++){
		    for(int j = 0; j < N; j++){
		        if(board[i][j] == 1) makeGroup(i, j, ++cnt);
		    }
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < N;  i++){
		    for(int j = 0; j < N; j++){
		        if(board[i][j] != 0){
		            int tmp = BFS(i, j);
		            if(tmp == -1) continue;
		            res = Math.min(res, tmp);
		        }
		    }
		}
		System.out.println(res);
	}
}
