/*
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int rowN = park.length;
        int colN = park[0].length();
        
        int[][] map = new int[rowN][colN];
        int sr = 0; int sc = 0;
        for(int i = 0; i < rowN; i++){
            for(int j = 0; j < colN; j++){
                char alpha = park[i].charAt(j);
                switch(alpha){
                    case 'S':
                        sr = i;
                        sc = j;
                        break;
                    case 'X':
                        map[i][j] = 1;
                        break;
                    default:
                        break;
                }
            }
        }
        
        int curlR = sr; int curlC = sc;
        for(String str : routes){
            boolean flag = true;
            int d = -1;
            switch(str.charAt(0)){
                case 'N':
                    d = 0;
                    break;
                case 'S':
                    d = 1;
                    break;
                case 'W':
                    d = 2;
                    break;
                case 'E':
                    d = 3;
                    break;
            }
            
            int n = str.charAt(2) - '0';
            
            for(int i = 1; i <= n; i++){
                int nr = curlR + dr[d] * i;
                int nc = curlC + dc[d] * i;
                
                if(nr < 0 || nr >= rowN || nc < 0 || nc >= colN || map[nr][nc] == 1){
                    flag = false;
                    break;
                }
            }

            if(flag){
                curlR = curlR + dr[d] * n;
                curlC = curlC + dc[d] * n;
            }
        }
        
        answer[0] = curlR;
        answer[1] = curlC;
        
        return answer;
    }
}
*/
import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int N = park.length;
        int M = park[0].length();
        int r = 0, c = 0;
        boolean[][] board = new boolean[N][M];
        int[][] dx = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                char ch = park[i].charAt(j);
                switch(ch){
                    case 'S': r = i; c = j; board[i][j] = true; break;
                    case 'O': board[i][j] = true;
                }
            }
        }
        
        for(String str : routes){
            StringTokenizer stk = new StringTokenizer(str);
            String dir = stk.nextToken();
            int dist = Integer.parseInt(stk.nextToken());
            int d = 0;
            switch(dir){
                case "N": d = 0; break;
                case "E": d = 1; break;
                case "S": d = 2; break;
                case "W": d = 3;
            }
            
            boolean flag = false;
            for(int i = 1; i <= dist; i++){
                int nr = r + dx[d][0] * i;
                int nc = c + dx[d][1] * i;
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || !board[nr][nc]){
                    flag = true;
                    break;
                }
            }
            
            if(flag) continue;
            r += dx[d][0] * dist;
            c += dx[d][1] * dist;  
        }
        
        answer[0] = r;
        answer[1] = c;
        
        return answer;
    }
}