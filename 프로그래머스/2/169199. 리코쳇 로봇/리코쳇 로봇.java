import java.util.*;

class Solution {
    
    public int solution(String[] board) {
        int answer = 0;
        int R = board.length;
        int C = board[0].length();
        boolean[][] visited = new boolean[R][C];
        int[][] map = new int[R][C];
        int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int sr = 0, sc = 0;
        
        for(int i = 0; i < R; i++){
            char[] arr = board[i].toCharArray();
            for(int j = 0; j < C; j++){
                switch(arr[j]){
                    case 'D':
                        map[i][j] = -1;
                        break;
                    case 'R':
                        sr = i; sc = j;
                        break;
                    case 'G':
                        map[i][j] = 2;
                        break;
                }
            }
        }
        
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(sr * C + sc);
        visited[sr][sc] = true;
        int size = 1;
        
        while(!Q.isEmpty()){
            if(size == 0){
                size = Q.size();
                answer++;
            }
            size--;
            int tmp = Q.poll();
            int cr = tmp / C, cc = tmp % C;
            
            if(map[cr][cc] == 2) return answer;
            
            for(int i = 0; i < 4; i++){
                int tr = cr, tc = cc;
                while(true){
                    int nr = tr + dx[i][0];
                    int nc = tc + dx[i][1];
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) break;
                    tr = nr; tc= nc;
                }
                
                if(visited[tr][tc]) continue;
                Q.add(tr * C + tc);
                visited[tr][tc] = true;
            }
            
        }

        return -1;
    }
}