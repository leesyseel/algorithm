import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int N = id_list.length;
        int[] answer = new int[N];
        
        Map<String, Integer> id_map = new HashMap<>();
        Set<Integer>[] list = new HashSet[N];
        for(int i = 0; i< N; i++){
            id_map.put(id_list[i], i);
            list[i] = new HashSet<Integer>();
        }
        
        for(String str : report){
            StringTokenizer stk = new StringTokenizer(str);
            int from = id_map.get(stk.nextToken());
            int to = id_map.get(stk.nextToken());
            list[to].add(from);
        }
        
        for(int i = 0; i < N; i++){
            if(list[i].size() < k) continue;
            
            for(int id : list[i]){
                answer[id]++;
            }
        }
        
        return answer;
    }
}