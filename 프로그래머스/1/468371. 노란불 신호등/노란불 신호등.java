class Solution {
    public int solution(int[][] signals) {
        
        int N = signals.length;
        int limit = 1;
        for(int i = 0; i < N; i++){
            int total = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, total);
        }
        
        for(int i = 1; i <= limit; i++){
            boolean flag = true;
            
            for(int[] tmp : signals){
                int G = tmp[0];
                int Y = tmp[1];
                int R = tmp[2];
                
                int cycle =  G + Y + R;
                int pos = (i - 1) % cycle;
                
                if(!(pos >= G && pos < G + Y)){
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        
        return -1;
    }
    
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    int lcm(int a, int b) {
        return a * b / (gcd(a,b));
    }

}