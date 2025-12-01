import java.util.*;
import java.io.*;

class Main{
    
    static class Virus implements Comparable<Virus>{
        int r, c;
        int depth;
        int num;
        
        public Virus(int r, int c, int depth, int num){
            this.r = r;
            this.c = c;
            this.depth = depth;
            this.num = num;
        }
        
        public int compareTo(Virus o){
            if(this.depth != o.depth) return this.depth - o.depth;
            return this.num - o.num;
        }
    }
    
    static int[][] arr;
    static int N, K;
    
    static void BFS(int S){
        
        int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<Virus> Q = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] != 0){
                    Q.add(new Virus(i, j, 0, arr[i][j]));
                }
            }
        }
        
        while(!Q.isEmpty()){
            
            Virus curl = Q.poll();
            if(curl.depth == S) break;
            
            for(int d = 0; d < 4; d++){
                int nr = curl.r + dx[d][0];
                int nc = curl.c + dx[d][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) continue;
                
                arr[nr][nc] = curl.num;
                Q.add(new Virus(nr, nc, curl.depth + 1, arr[nr][nc]));
            }
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
        
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        
        stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken());
        int X = Integer.parseInt(stk.nextToken()) - 1;
        int Y = Integer.parseInt(stk.nextToken()) - 1;
        
        BFS(S);
        System.out.println(arr[X][Y]);
	}
}