import java.util.*;
import java.io.*;

class Main{
    
    static int N;
    static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    static int[][] path;
    
    static void solve(int r, int c){
        int num = map[r][c];
        int max = 0;
        
        for(int d = 0; d < 4; d++){
            int nr = r + dt[d][0];
            int nc = c + dt[d][1];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            
            if(num < map[nr][nc]){
                if(path[nr][nc] == 0) solve(nr, nc);
                max = Math.max(max, path[nr][nc]);
            }
        }
        path[r][c] = max + 1;
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		path = new int[N][N];
		
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    for(int j = 0; j < N; j++){
		        map[i][j] = Integer.parseInt(stk.nextToken());
		    }
		}
		
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < N; j++){
		        if(path[i][j] != 0) continue;
		        solve(i, j);
		    }
		}
		
		int res = 0;
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < N; j++){
		        res = Math.max(res, path[i][j]);
		    }
		}
		
		System.out.println(res);
	}
}
