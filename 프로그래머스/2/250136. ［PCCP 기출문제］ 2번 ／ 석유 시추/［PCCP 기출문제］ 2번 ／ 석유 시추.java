import java.util.*;

class Solution {
    
    static int N, M;
    static int num;
    static int[][] board;
    static HashMap<Integer, Integer> map;
    
    static void findGroup(int r, int c, int[][] land){
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{r, c});
        land[r][c] = 0;
        board[r][c] = num;
        int score = 0;
        
        while(!Q.isEmpty()){
            int[] curl = Q.poll();
            score++;
            
            for(int d = 0; d < 4; d++){
                int nr = curl[0] + dr[d];
                int nc = curl[1] + dc[d];
                
                if(nr >=0 && nr < N && nc >= 0 && nc < M && land[nr][nc] == 1){
                    board[nr][nc] = num;
                    land[nr][nc] = 0;
                    Q.add(new int[]{nr, nc});
                }
            }
        }
        map.put(num++, score);
    }
    
    public int solution(int[][] land) {
        
        N = land.length;
        M = land[0].length;
        board = new int[N][M];
        map = new HashMap<>();
        num = 1;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(land[i][j] == 1){
                    findGroup(i, j, land);
                }
            }
        }
        
        int answer = 0;
        for(int c = 0; c < M; c++){
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int r = 0; r < N; r++){
                if(board[r][c] != 0 && !set.contains(board[r][c])){
                    sum += map.get(board[r][c]);
                    set.add(board[r][c]);
                }
            }
            answer = sum > answer ? sum : answer;
        }
        return answer;
    }
}