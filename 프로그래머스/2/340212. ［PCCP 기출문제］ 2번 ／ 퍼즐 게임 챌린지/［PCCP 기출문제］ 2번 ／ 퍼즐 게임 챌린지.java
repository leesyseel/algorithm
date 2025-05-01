class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        
        int left = 1;
        int right = 100000;
        int len = diffs.length;
        
        while(left <= right){
            int mid = (left + right) / 2;
            long sum = 0;
            boolean flag = false;
            
            for(int i = 0; i < len; i++){
                
                if(diffs[i] > mid && i > 0){
                    sum += (diffs[i] - mid) * (times[i - 1] + times[i]);
                }
            
                sum += times[i];
                
                if(sum > limit){
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                left = mid + 1;
                continue;
            }
            
            if(answer >= mid){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }   
        return answer;
    }
}