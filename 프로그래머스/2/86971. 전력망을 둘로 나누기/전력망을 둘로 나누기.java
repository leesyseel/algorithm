import java.util.*;

class Solution {
    
    boolean[] visited;
    ArrayList<Integer>[] list;
    
    public void DFS(int curl, int[] cutted){
        visited[curl] = true;
        
        for(int nxt : list[curl]){
            if(visited[nxt]) continue;
            
            if((cutted[0] == curl && cutted[1] == nxt) || (cutted[1] == curl && cutted[0] == nxt)) continue;
            DFS(nxt, cutted);
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int[] wire : wires){
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        for(int[] wire : wires){
            visited = new boolean[n + 1];
            DFS(wire[0], wire);
            
            int cnt  = 0;
            for(int i = 1; i <= n; i++){
                if(visited[i]) cnt++;
            }
            answer =  Math.min(answer, Math.abs(2 * cnt - n));
        }
        
        return answer;
    }
}