import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            Q.add(scoville[i]);
        }
        boolean flag = false;
        
        while(true){
            int f1 = Q.poll();
            if(f1 >= K){
                flag = true;
                break;
            }
            
            if(Q.isEmpty()) break;
            
            int f2 = Q.poll();
            Q.add(f1 + (f2 * 2));
            answer++;
        }
        if(!flag) answer = -1;
        return answer;
    }
}