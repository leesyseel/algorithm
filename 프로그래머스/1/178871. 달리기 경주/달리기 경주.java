import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        int N = players.length;
        String[] answer = new String[N];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            map.put(players[i], i);
            answer[i] = players[i];
        }
        
        for(String str : callings){
            int idx = map.get(str);
            String tmp = answer[idx - 1];
            answer[idx - 1] = str;
            answer[idx] = tmp;
            map.replace(str, idx - 1);
            map.replace(tmp, idx);
        }
        
        return answer;
    }
}