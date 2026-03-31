import java.util.*;
class Solution {
    
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int R, C;
    static int[][] board;
    static boolean[][][] visited;
    static List<Integer> answer;
    
    public void solve(int sr, int sc, int sd){
        visited[sr][sc][sd] = true;
        Queue<int[]> Q = new ArrayDeque<>();
        Q.add(new int[] {sr, sc, sd});
        int cnt = 0;
        
        while(!Q.isEmpty()){
            int[] tmp = Q.poll();
            int r = tmp[0];
            int c = tmp[1];
            
            int nd = (board[r][c] + tmp[2] + 4) % 4;
            int nr = (tmp[0] + dx[nd][0] + R) % R;
            int nc = (tmp[1] + dx[nd][1] + C) % C;
            
            if(nr == sr && nc == sc && nd == sd){
                answer.add(cnt + 1);
                return;
            }
            if(visited[nr][nc][nd]) continue;
            
            visited[nr][nc][nd] = true;
            Q.add(new int[] {nr, nc, nd});
            cnt++;
        }
        
    }
    
    public int[] solution(String[] grid) {
        
        answer = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();
        board = new int[R][C];
        visited = new boolean[R][C][4];
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i].charAt(j) == 'L') board[i][j] = -1;
                else if(grid[i].charAt(j) == 'R') board[i][j] = 1;
            }
        }
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                for(int k = 0; k < 4; k++){
                    if(visited[i][j][k]) continue;
                    solve(i, j, k);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}