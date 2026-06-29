import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int N = prices.length;
        int[] answer = new int[N];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++){
            if(stack.isEmpty() || stack.peekLast()[1] <= prices[i]){
                stack.addLast(new int[] {i, prices[i]});
                continue;
            }
            
            while(!stack.isEmpty() && stack.peekLast()[1] > prices[i]){
                int[] tmp = stack.pollLast();
                answer[tmp[0]] = i - tmp[0];
            }
            stack.addLast(new int[] {i, prices[i]});
        }
        
        while(!stack.isEmpty()){
            int[] tmp = stack.pollLast();
            answer[tmp[0]] = N - tmp[0] - 1;
        }
        
        return answer;
    }
}