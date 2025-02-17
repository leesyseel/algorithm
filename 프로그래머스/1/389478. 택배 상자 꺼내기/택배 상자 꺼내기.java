import java.util.*; 
class Solution {
    public int solution(int n, int w, int num) {
        int row = (int) Math.ceil((double) n / w);
        int[][] map = new int[row][w];
        
        int[] dc = {1, -1};
        int number = 1;
        int d = 0;
        int col = 0;
        
        int fr = -1; int fc = -1;
        
        for(int r = row - 1; r >= 0; r--){
            for(int c = 0; c < w; c++){
                
                if(number == num){
                    fr = r; fc = col;
                }
                map[r][col] = number++;
                col += dc[d];
            }
            d = (d + 1) % 2;
            col += dc[d];
        }
        
        int answer = 0;
        for(int r = fr; r>= 0; r--){
            if(map[r][fc] <= n) answer++;
        }
        return answer;
    }
}