import java.util.*;
import java.io.*;

class Main{
    
    static class  State{
        int bR, bC, rR, rC;
        int cnt;
        
        public State(int br, int bc, int rr, int rc, int cnt){
            this.bR = br;
            this.bC = bc;
            this.rR = rr;
            this.rC = rc;
            this.cnt = cnt;
        } 
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int bR = 0, bC = 0, rR = 0, rC = 0, eR = 0, eC = 0;
		int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌
		
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i++){
		    board[i] = br.readLine().toCharArray();
		    for(int j = 0; j < M; j++){
		        if(board[i][j] == 'B'){
		            bR = i; bC = j;
		        }else if(board[i][j] == 'R'){
		            rR = i; rC = j;
		        }else if(board[i][j] == 'O'){
		            eR = i; eC = j;
		        }
		    }
		}
		
		int res = -1;
		boolean isB = false, isR = false;
		Queue<State> Q = new ArrayDeque<>();
		Q.add(new State(bR, bC, rR, rC, 0));
		
		while(!Q.isEmpty()){
		    State curl = Q.poll();
		    if(curl.cnt >= 10) break;
		    
		    for(int d = 0; d < 4; d++){
		        isB = isR = false;
		        int nbR = curl.bR, nbC = curl.bC, nrR = curl.rR, nrC = curl.rC;
		        
		        // blue 이동
		        while(true){
		            int tmpR = nbR + dx[d][0];
		            int tmpC = nbC + dx[d][1];
		            if(board[tmpR][tmpC] == '#') break;
		            
		            nbR = tmpR; nbC = tmpC;
		            if(nbR == eR && nbC == eC){
		                isB = true;
		                break;
		            }
		        }
		        
		        // red 이동
		        while(true){
		            int tmpR = nrR + dx[d][0];
		            int tmpC = nrC + dx[d][1];
		            if(board[tmpR][tmpC] == '#') break;
		            
		            nrR = tmpR; nrC = tmpC;
		            if(nrR == eR && nrC == eC){
		                isR = true;
		                break;
		            }
		        }

		        if(isB) continue;
		        if(isR){
		            res = curl.cnt + 1;
		            break;
		        }
		        
		        if(nbR == nrR && nbC == nrC){
		            if(d == 0){
		                if(curl.bR > curl.rR) nbR -= dx[d][0];
		                else nrR -= dx[d][0];
		            }else if(d == 1){
		                if(curl.bC > curl.rC) nrC -= dx[d][1];
		                else nbC -= dx[d][1];
		            }else if(d == 2){
		                if(curl.bR > curl.rR) nrR -= dx[d][0];
		                else nbR -= dx[d][0];
		            }else{
		                if(curl.bC > curl.rC) nbC -= dx[d][1];
		                else nrC -= dx[d][1];
		            }
		        }
		        Q.add(new State(nbR, nbC, nrR, nrC, curl.cnt + 1));
		    }
		    if(res != -1) break;
		}
		System.out.println(res);
	}
}