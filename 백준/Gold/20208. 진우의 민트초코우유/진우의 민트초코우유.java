import java.util.*;
import java.io.*;

class Main {
    
    static int N, M, H, res, sr, sc;
    static boolean[] visited;
    static ArrayList<Integer> milk;
    
    static void solve(int r, int c, int power, int cnt){
        
        int distHome = Math.abs(sr - r) + Math.abs(sc - c);
        if(distHome <= power){
            res = Math.max(res, cnt);
        }
        
        for(int i = 0; i < milk.size(); i++){
            int tmp = milk.get(i);
            int nr = tmp / N;
            int nc = tmp % N;
            int dist = Math.abs(r - nr) + Math.abs(c - nc);
            
            if(dist > power || visited[i]) continue;
            
            visited[i] = true;
            solve(nr, nc, power - dist + H, cnt + 1);
            visited[i] = false;
        }
        
    }
    
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		H = Integer.parseInt(stk.nextToken());
		milk = new ArrayList<>();
		
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    for(int j = 0; j < N; j++){
		        int tmp = Integer.parseInt(stk.nextToken());
		        
		        if(tmp == 1){
		            sr = i;
		            sc = j;
		        }else if(tmp == 2){
		            milk.add(i * N + j);
		        }
		    }
		}
		visited = new boolean[milk.size()];
		
		res = 0;
		solve(sr, sc, M, 0);
		System.out.println(res);
	}
}
