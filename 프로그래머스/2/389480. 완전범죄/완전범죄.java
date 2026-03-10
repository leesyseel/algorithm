import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int INF = 121;
        
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int[] curl : info){
            int[] tmp = new int[m];
            Arrays.fill(tmp, INF);
            
            // 현재 B가 누적값이 i일 때 curl 물건을 훔치는 경우
            for(int i = 0; i < m; i++){
                if(dp[i] == INF) continue;
                
                int na = dp[i] + curl[0]; // A가 훔침
                int nb = i + curl[1]; // B가 훔침
                
                if(na < n){
                    tmp[i] = Math.min(tmp[i], na);
                }
                if(nb < m){
                    tmp[nb] = Math.min(tmp[nb], dp[i]);
                }
            }
            dp = tmp;
        }
        
        int answer = INF;
        for(int i = 0; i < m; i++){
            answer = Math.min(answer, dp[i]);
        }
        
        return answer == INF ? -1 : answer;
    }
}