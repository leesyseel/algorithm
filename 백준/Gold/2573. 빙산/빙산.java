import java.util.*;
import java.io.*;

class Main{
    
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    static void melt(){
        int[][] nxt = new int[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0) continue;
                
                int cnt = 0;
                for(int d = 0; d < 4; d++){
                    int nr = i + dx[d][0];
                    int nc = j + dx[d][1];
                    
                    if(map[nr][nc] != 0) continue;
                    cnt++;
                }
                nxt[i][j] = map[i][j] < cnt ? 0 : map[i][j] - cnt; 
            }
        }
        map = nxt;
    }
    
    static int groupCount(){
        visited = new boolean[N][M];
        int cnt = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    BFS(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    static void BFS(int r, int c){
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[] {r, c});
        visited[r][c] = true;
        
        while(!Q.isEmpty()){
            int[] tmp = Q.poll();
            int cr = tmp[0]; int cc = tmp[1];
            
            for(int d = 0; d < 4; d++){
                int nr = cr + dx[d][0];
                int nc = cc + dx[d][1];
                    
                if(map[nr][nc] == 0 || visited[nr][nc]) continue;
                
                Q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    for(int j = 0; j < M; j++){
		        map[i][j] = Integer.parseInt(stk.nextToken());
		    }
		}
		
		int res = 0;
		int time = 0;
		while(true){
		    
		    int tmp = groupCount();
		    if(tmp >= 2){
		        res = time;
		        break;
		    }else if(tmp == 0){
		        res = 0;
		        break;
		    }
		    
		    time++;
		    melt();
		}
		System.out.println(res);
	}
}
