import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++){
            Q.add(0);
        }
        
        int curlW = 0;
        int answer = 0;
        int idx = 0, len = truck_weights.length;
        
        while(idx < len || curlW > 0){
            answer++;
            curlW -= Q.poll();
            
            if(idx < len && curlW + truck_weights[idx] <= weight){
                curlW += truck_weights[idx];
                Q.add(truck_weights[idx]);
                idx++;
            }else{
                Q.add(0);
            }
        }

        return answer;
    }
}