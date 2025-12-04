import java.util.*;
import java.io.*;

class Main{
    
    static int N, M;
    static int[][] arr;
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<Integer> Q;
    
    static void seperateAir(){
        Queue<Integer> innerQ = new ArrayDeque<>();
        innerQ.add(0);
        arr[0][0] = -1;
        
        while(!innerQ.isEmpty()){
            int curl = innerQ.poll();
            int r = curl / M;
            int c = curl % M;
            
            for(int d = 0; d < 4; d++){
                int nr = r + dx[d][0];
                int nc = c + dx[d][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] != 0) continue;
                innerQ.add(nr * M + nc);
                arr[nr][nc] = -1;
            }
        }
        
        for(int i = 1; i < N - 1; i++){
		    for(int j = 1; j < M - 1; j++){
		        if(arr[i][j] == 0) arr[i][j] = -2;
		    }
        }
    }
    
    static void intakeAir(int sr, int sc){
        Queue<Integer> innerQ = new ArrayDeque<>();
        innerQ.add(sr * M + sc);
        arr[sr][sc] = -1;
        
        while(!innerQ.isEmpty()){
            int curl = innerQ.poll();
            int r = curl / M;
            int c = curl % M;
            
            for(int d = 0; d < 4; d++){
                int nr = r + dx[d][0];
                int nc = c + dx[d][1];
                
                if(arr[nr][nc] >= 0){
		            if(++arr[nr][nc] >= 2){
		                Q.add(nr * M + nc);
		                arr[nr][nc] = -1;
		            }
		        }else if(arr[nr][nc] == -2){
		            arr[nr][nc] = -1;
		            innerQ.add(nr * M + nc);
		        }
            }
        }
    } 
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    for(int j = 0; j < M; j++){
		        arr[i][j] = Integer.parseInt(stk.nextToken());
		    }
		}
		
		// 내외부 공기 구분
		seperateAir();
		
		Q = new ArrayDeque<>();
		boolean[][] check = new boolean[N][M];
		
		// 치즈 값을 exAir 개수로 값 바꾸고, exAir >= 2이면 Q에 삽입
		for(int i = 1; i < N - 1; i++){
		    for(int j = 1; j < M - 1; j++){
		        if(arr[i][j] != 1) continue;
		            
		        int exAir = 0;
		        for(int d = 0; d < 4; d++){
		            int nr = i + dx[d][0];
		            int nc = j + dx[d][1];
		            if(!check[nr][nc] && arr[nr][nc] == -1) exAir++;
		        }      
		        arr[i][j] = exAir;
		        if(exAir >= 2){
		            Q.add(i * M + j);
		            arr[i][j] = -1;
		            check[i][j] = true;
		        }
		    }
		}
		
		int day = -1;
		int len = 0;

		while(!Q.isEmpty()){
		    if(len == 0){
		        day++;
		        len = Q.size();
		    }
		    len -= 1;
		    int curl = Q.poll();
		    int r = curl / M;
		    int c = curl % M;
		    
		    for(int d = 0; d < 4; d++){
		        int nr = r + dx[d][0];
		        int nc = c + dx[d][1];
		        
		        if(arr[nr][nc] >= 0){
		            if(++arr[nr][nc] >= 2){
		                Q.add(nr * M + nc);
		                arr[nr][nc] = -1;
		            }
		        }else if(arr[nr][nc] == -2){
		            intakeAir(nr, nc);
		        }
		    }
		}
		System.out.println(day + 1);
	}
}
