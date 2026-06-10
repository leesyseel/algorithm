import java.util.*;

class Solution {
    static int answer, N, K; // N = stage 개수, K = 한 번들에 포함된 힌트 수
    static HashMap<Integer, Integer> map;
    
    static void DFS(int stage, int sum, int[][] cost, int[][] hint){
        
        if(stage == N){
            answer = Math.min(answer, sum);
            return;
        }
        
        int hintCnt = map.getOrDefault(stage, 0);
        hintCnt = hintCnt >= N ? N - 1 : hintCnt; 
        int tmp = cost[stage][hintCnt];
        DFS(stage + 1, sum + tmp, cost, hint);
        if(stage == N - 1) return;
        
        //힌트 구매
        tmp += hint[stage][0];
        for(int i = 1; i < K; i++){
            map.put(hint[stage][i] - 1, map.getOrDefault(hint[stage][i] - 1, 0) + 1);
        }
        DFS(stage + 1, sum + tmp, cost, hint);
        for(int i = 1; i < K; i++){
            map.put(hint[stage][i] - 1, map.get(hint[stage][i] - 1) - 1);
        }
    }
    
    public int solution(int[][] cost, int[][] hint) {
        answer = Integer.MAX_VALUE;
        N = cost.length;
        K = hint[0].length;
        map = new HashMap<>();
        
        DFS(0, 0, cost, hint);
        
        return answer;
    }
}