import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : topping){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int t : topping){
            set.add(t);
            int remain = map.get(t) - 1;
            
            if(remain == 0){
                map.remove(t);
            }else{
                map.replace(t, remain);
            }
            
            if(set.size() == map.size()) answer++;
        }      
        
        return answer;
    }
}