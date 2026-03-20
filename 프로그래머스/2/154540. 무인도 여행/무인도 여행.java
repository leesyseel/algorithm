import java.util.*;

class Solution {
    static int[][] board;
    static int R, C;
    static ArrayList<Integer> list;
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void solve(int r, int c){
        int sum = board[r][c];
        board[r][c] = 0;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(r * C + c);
        
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            int sr = tmp / C;
            int sc = tmp % C;
            
            for(int d = 0; d < 4; d++){
                int nr = sr + dx[d][0];
                int nc = sc + dx[d][1];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == 0) continue;
                sum += board[nr][nc];
                board[nr][nc] = 0;
                Q.add(nr * C + nc);
            }
        }
        list.add(sum);
    }
    
    public int[] solution(String[] maps) {
        
        R = maps.length;
        C = maps[0].length();
        board = new int[R][C];
        list = new ArrayList<>();
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(maps[i].charAt(j) == 'X') continue;
                board[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(board[i][j] != 0) solve(i, j);
            }
        }
        
        if(list.size() == 0) list.add(-1);
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}