class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int N = board.length;
        int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int answer = 0;
        
        for(int d = 0; d < 4; d++){
            int nr = h + dx[d][0];
            int nc = w + dx[d][1];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            
            if(board[h][w].equals(board[nr][nc])) answer++;
        }
        
        return answer;
    }
}