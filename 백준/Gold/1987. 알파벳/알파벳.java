import java.util.*;
import java.io.*;

class Main{
    
    static int R, C, res;
    static char[][] arr;
    static boolean[] alpha;
	static boolean[][] visited;
	static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static void DFS(int r, int c, int cnt){
	    res = Math.max(res, cnt);
	    for(int d = 0; d < 4; d++){
	        int nr = r + dx[d][0];
	        int nc = c + dx[d][1];
	        
	        if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
	        if(visited[nr][nc] || alpha[arr[nr][nc] - 'A']) continue;
	        
	        visited[nr][nc] = alpha[arr[nr][nc] - 'A'] = true;
	        DFS(nr, nc, cnt + 1);
	        visited[nr][nc] = alpha[arr[nr][nc] - 'A'] = false;
	    }
	}
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		
		alpha = new boolean[26];
		visited = new boolean[R][C];
		arr = new char[R][C];
		for(int i = 0; i < R; i++){
		    arr[i] = br.readLine().toCharArray();
		}
		
		res = 1;
		visited[0][0] = alpha[arr[0][0] - 'A'] = true;
		DFS(0, 0, 1);
		System.out.println(res);
	}
}
