import java.util.*;

class Solution {
    public int solution(int n) {

        if(n % 2 != 0) return 0;
        else if(n == 0) return 1;
        else if(n == 2) return 3;
        else if(n == 4) return 11;
        
        long[] dp = new long[n + 1];
        dp[0] = 1; dp[2] = 3; dp[4] = 11;
        int MOD = 1_000_000_007;
        
        for(int i = 6; i <= n; i += 2){
            dp[i] = (4 * dp[i - 2] - dp[i - 4]) % MOD;
            if (dp[i] < 0) dp[i] += MOD;
        }
        
        return (int) dp[n];
    }
}