class Solution {
    public int[] solution(int[] sequence, int k) {
            
        int N = sequence.length;
        int[] answer = {0, N - 1};
        int lt = 0, rt = 0, len = N;
        int sum = sequence[0];
        
        while(lt <= rt){
            if(sum == k){
                if(len > rt - lt + 1){
                    answer[0] = lt; answer[1] = rt;
                    len = rt - lt + 1;
                }
                sum -= sequence[lt++];
            }else if(sum < k){
                if(rt + 1 < N){
                    sum += sequence[++rt];
                }else{
                    break;
                }
            }else{
                sum -= sequence[lt++];
            }
        }
        
       return answer;
    }
}