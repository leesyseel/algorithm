import java.util.*;

class Solution {
    
    static int len;
    static boolean[] visited;
    static ArrayList<String> list;
    
    static void DFS(int depth, String now, String path, String[][] tickets){
        if(depth == len){
            list.add(path);
            return;
        }
        
        for(int i = 0; i < len; i++){
            if(visited[i] || !now.equals(tickets[i][0])) continue;
            visited[i] = true;
            DFS(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
            visited[i] = false;
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        len = tickets.length;
        list = new ArrayList<>();
        visited = new boolean[len];
        DFS(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        return list.get(0).split(" ");
    }
}