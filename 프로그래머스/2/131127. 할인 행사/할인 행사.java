import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++){
            String str = discount[i];
            if(map.containsKey(str)){
                map.put(str, map.get(str) - 1);
            }
        }
        
        for(int i = 9; i < discount.length; i++){
            
            String tmp;
            boolean flag = true;
            for(String str : want){
                if(map.get(str) != 0){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
            if(i + 1 >= discount.length) break;
            
            tmp = discount[i + 1];
            if(map.containsKey(tmp))    map.put(tmp, map.get(tmp) - 1);
            tmp = discount[i - 9];
            if(map.containsKey(tmp))    map.put(tmp, map.get(tmp) + 1);
            
        }    
        
        return answer;
    }
}