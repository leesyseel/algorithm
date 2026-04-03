class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        int[][] ratio = {{1, 2}, {2, 3}, {3, 4}};
        int[] cnt = new int[1001];
        for(int w : weights){
            cnt[w]++;
        }
        
        for(int i = 100; i < 1001; i++){
            if(cnt[i] == 0) continue;
            answer += (long) (cnt[i] - 1) * cnt[i] / 2;
            
            for(int[] tmp : ratio){
                if(i % tmp[0] != 0) continue;
                int w = i / tmp[0] * tmp[1];
                if(w <= 1000 && cnt[w] != 0) answer += (long) cnt[i] * cnt[w];
            }
        }
        
        return answer;
    }
}