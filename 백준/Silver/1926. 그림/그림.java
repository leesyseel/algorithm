import java.util.*;
import java.io.*;

class Main{
    static int[][] board;
    static int R, C;
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    static int BFS(int sr, int sc){
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(sr * C + sc);
        board[sr][sc] = 0;
        
        int cnt = 0;
        while(!Q.isEmpty()){
            cnt++;
            int tmp = Q.poll();
            int r = tmp / C;
            int c = tmp % C;
            
            for(int d = 0; d < 4; d++){
                int nr = r + dx[d][0];
                int nc = c + dx[d][1];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == 0) continue;
                Q.add(nr * C + nc);
                board[nr][nc] = 0;
            }
        }
        return cnt;
    }
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    stk = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(stk.nextToken());
	    C = Integer.parseInt(stk.nextToken());
	    board = new int[R][C];
	    
	    for(int i = 0; i < R; i++){
	        stk = new StringTokenizer(br.readLine());
	        for(int j = 0; j < C; j++){
	            board[i][j] = Integer.parseInt(stk.nextToken());
	        }
	    }
	    
	    int cnt = 0;
	    int max = 0;
	    
	    for(int i = 0; i < R; i++){
	        for(int j = 0; j < C; j++){
	            if(board[i][j] == 1){
	                cnt++;
	                max = Math.max(BFS(i, j), max);
	            }
	        }
	    }
        System.out.println(cnt+"\n"+max);
	}
}