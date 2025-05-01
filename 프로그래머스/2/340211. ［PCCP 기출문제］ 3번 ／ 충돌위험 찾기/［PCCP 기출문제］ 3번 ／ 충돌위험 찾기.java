import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            map.put(i + 1, points[i][0] * 1000 + points[i][1]);
        }
        
        Queue<Integer>[] Q = new ArrayDeque[routes.length];
        for(int i = 0; i < routes.length; i++){
            Q[i] = new ArrayDeque<>();
            int curl = map.get(routes[i][0]);
            Q[i].add(curl);
            
            for(int j = 1; j < routes[i].length; j++){
                int nxt = map.get(routes[i][j]);
                
                while(curl / 1000 != nxt / 1000){
                    curl = curl > nxt ? curl - 1000 : curl + 1000;
                    Q[i].add(curl);
                }
                
                while(curl % 1000 != nxt % 1000){
                    curl = curl > nxt ? curl - 1 : curl + 1;
                    Q[i].add(curl);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < routes.length; i++){
            max = max > Q[i].size() ? max : Q[i].size();
        }
        
        for(int j = 0; j < max; j++){
            HashMap<Integer, Integer> check = new HashMap<>();
            for(int i = 0; i < routes.length; i++){
                if(Q[i].isEmpty()) continue;
                
                int key = Q[i].poll();
                if(check.containsKey(key)){
                    check.put(key, check.get(key) + 1);
                }else{
                    check.put(key, 1);
                }
            }
            
            for(int key : check.keySet()){
                if(check.get(key) > 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}