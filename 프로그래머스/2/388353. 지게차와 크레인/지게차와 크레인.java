import java.util.*;

class Solution {
    static int R, C;
    static int[][] board;
    static int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(String[] storage, String[] requests) {
        
        R = storage.length;
        C = storage[0].length();
        board = new int[R + 2][C + 2];
        int answer = R * C;
        
        for(int i = 1; i <= R; i++){
            Arrays.fill(board[i], -1);
            for(int j = 1; j <= C; j++){
                board[i][j] = storage[i - 1].charAt(j - 1) - 'A';
            }
        }
        Arrays.fill(board[0], -1);
        Arrays.fill(board[R + 1], -1);
        
        for(String str : requests){
            if(str.length() == 1){
                answer -= removeBorder(str.charAt(0) - 'A');
            }else{
                answer -= removeAll(str.charAt(0) - 'A');
            }
        }
        
        return answer;
    }
    
    public int removeBorder(int alpha){
        int cnt = 0;
        boolean[][] visited = new boolean[R + 2][C + 2];
        Queue<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i < C + 2; i++){
            Q.add(i);
            Q.add((R + 1) * (C + 2) + i);
            visited[0][i] = visited[R + 1][i] = true;
        }
        for(int i = 0; i < R + 2; i++){
            Q.add(i * (C + 2));
            Q.add(i * (C + 2) + C + 1);
            visited[i][0] = visited[i][C + 1] = true;
        }
        
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            int sr = tmp / (C + 2);
            int sc = tmp % (C + 2);
            
            if(board[sr][sc] == alpha){
                cnt++;
                board[sr][sc] = -1;
                continue;
            }
            
            if(board[sr][sc] != -1) continue;
            
            for(int d = 0; d < 4; d++){
                int nr = sr + dx[d][0];
                int nc = sc + dx[d][1];
                
                if(nr < 0 || nr >= R + 2 || nc < 0 || nc >= C + 2 || visited[nr][nc]) continue;
                
                Q.add(nr * (C + 2) + nc);
                visited[nr][nc] = true;
            }
        }
        
        return cnt;
    }
    
    public int removeAll(int alpha){
        int cnt = 0;
        
        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if(board[i][j] == alpha){
                    cnt++;
                    board[i][j] = - 1;
                }
            }
        }
        return cnt;
    }
}