class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        int n = players.length;
        
        for(int i = 0; i < n; i++){
            if(server[i] * m >= players[i]) continue;
            
            int need = players[i] / m;
            int tmp = need - server[i];
            answer += tmp;
            
            for(int j =0; j < k; j++){
                if(i + j >= 24) break;
                server[i + j] += tmp;
            }
        }
        
        return answer;
    }
}