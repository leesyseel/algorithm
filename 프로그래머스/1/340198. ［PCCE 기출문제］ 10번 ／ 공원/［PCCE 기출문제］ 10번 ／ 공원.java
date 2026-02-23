import java.util.*;

class Solution {
    
    static int R, C;
    
    static boolean check(int sr, int sc, int len, String[][] park){
        
        if(sr + len > R || sc + len > C) return false;
        
        for(int i = sr; i < sr + len; i++){
            for(int j = sc; j < sc + len; j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
    
    public int solution(int[] mats, String[][] park) {
        
        int answer = -1;
        R = park.length;
        C = park[0].length;
        Arrays.sort(mats);
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                
                if(!park[i][j].equals("-1")) continue;
                
                for(int k = mats.length - 1; k >= 0; k--){
                    int len = mats[k];
                    if(len <= answer) break;
                    
                    if(check(i, j, len, park)){
                        answer = len; 
                    }
                }
            }
        }
        
        return answer;
    }
}