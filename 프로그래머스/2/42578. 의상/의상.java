import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> clotheType = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            
            clotheType.put(clothes[i][1], clotheType.getOrDefault(clothes[i][1], 0) + 1);
            
            // if(clotheType.containsKey(clothes[i][1])){
            //     clotheType.replace(clothes[i][1],clotheType.get(clothes[i][1]) + 1);
            // }else{
            //     clotheType.put(clothes[i][1], 1);
            //  }
        }
        
        int answer = 1;
        for(String key : clotheType.keySet()){
            answer *= (clotheType.get(key) + 1);
        }
        return answer - 1;
    }
}