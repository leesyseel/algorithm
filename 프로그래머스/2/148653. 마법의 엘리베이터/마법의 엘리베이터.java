import java.util.*;

class Solution {

    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0){
            int one = storey % 10;
            storey /= 10;
            int ten = (storey) % 10;
            
            if(one > 5){
                storey++;
                answer += 10 - one;
            }else if(one == 5){
                answer += one;
                storey += (ten >= 5 ? 1 : 0);
            }else{
                answer += one;
            }
        }
        
        return answer;
    }
}