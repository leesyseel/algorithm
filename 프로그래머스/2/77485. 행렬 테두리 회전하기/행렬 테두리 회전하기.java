class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] dx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int len = queries.length;
        int[] answer = new int[len];
        int[][] board = new int[rows][columns];
        int num = 1;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < columns; j++){
                board[i][j] = num++;
            }
        }
        
        for(int i = 0; i < len; i++){
            int r1 = queries[i][0] - 1, c1 = queries[i][1] - 1, r2 = queries[i][2] - 1, c2 = queries[i][3] - 1;
            int val = board[r1][c1];
            int min = Math.min(val, Integer.MAX_VALUE);
            int dir = 0, sr = r1, sc = c1;
            while(dir < 4){
                int nr = sr + dx[dir][0];
                int nc = sc + dx[dir][1];
                
                if(nr < r1 || nr > r2 || nc < c1 || nc > c2){
                    dir++;
                    continue;
                }
                if(nr == r1 && nr == r2){
                    board[nr][nr] = val;
                    break;
                }
                
                int tmp = board[nr][nc];
                board[nr][nc] = val;
                val = tmp;
                min = Math.min(min, val);
                sr = nr; sc = nc;
            }
            answer[i] = min;   
        }
        
        return answer;
    }
}