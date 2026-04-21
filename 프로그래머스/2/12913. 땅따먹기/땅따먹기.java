class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int R = land.length;
        int C = 4;
        int[][] dp = new int[R][C];
        
        for (int i = 0; i < C; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C; j++) {
                 for (int k = 0; k < C; k++) {
                     if (j == k) continue;
                     dp[i + 1][k] = Math.max(dp[i][j] + land[i + 1][k], dp[i + 1][k]);
                 }
            }
        }
        
        for (int i = 0; i < C; i++) {
            answer = Math.max(dp[R - 1][i], answer);
        }

        return answer;
    }
}
