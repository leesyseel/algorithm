import java.util.*;

class Solution {


    public String solution(String number, int k) {
        
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        
        for(int i = 0; i < number.length(); i++){
            int num = number.charAt(i) - '0';
            
            while(!Q.isEmpty()){
                if(k > 0 && Q.peekLast() < num){
                    Q.pollLast();
                    k--;
                }else{
                    break;
                }
            }
            Q.add(num);
        }
        while (k > 0) {
            Q.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!Q.isEmpty()){
            sb.append(Q.poll());
        }
        
        return sb.toString();
    }
}
