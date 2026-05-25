import java.util.*;
class Solution {
    public int[] solution(int n) {
        
        int N = (n * (n + 1)) / 2;
        int[][] arr = new int[n][n];
        int[] answer = new int[N];
        int[][] dx = {{1, 0}, {0, 1}, {-1, -1}};
        
        int num = 1;
        int d = 0;
        int r = 0; int c = 0;
        
        while(num <= N){
            arr[r][c] = num++;
            int nr = r + dx[d][0];
            int nc = c + dx[d][1];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != 0){
                d = (d + 1) % 3;
                nr = r + dx[d][0];
                nc = c + dx[d][1];
            }
            r = nr; c = nc;
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0) break;
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}