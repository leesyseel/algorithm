import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        int N = cards.length;
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[N];
        
        for(int i = 0; i < N; i++){
            int idx = cards[i] - 1;
            
            int cnt = 0;
            while(!visited[idx]){
                cnt++;
                visited[idx] = true;
                idx = cards[idx] - 1;
            }
            
            if(cnt != 0) list.add(cnt);
        }
        
        if(list.size() == 1) return 0;
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0) * list.get(1);
    }
}