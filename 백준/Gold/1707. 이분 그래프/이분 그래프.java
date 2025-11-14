import java.util.*;
import java.io.*;

class Main{
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] group;
    static int V, E;
    
    static boolean DFS(int idx, int g){
        
        for(int nxt : arr[idx]){
            if(visited[nxt]){
                if(group[nxt] == group[idx]){
                    return false;
                }
                continue;
            }
            
            visited[nxt] = true;
            group[nxt] = (g + 1) % 2 == 0 ? 2 : 1;
            if(!DFS(nxt, group[nxt])){
                return false;
            }
            visited[nxt] = true;
        }
        return true;
    }
    
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer stk;
	    
	    int TC = Integer.parseInt(br.readLine());
	    while(TC-- > 0){
	        stk = new StringTokenizer(br.readLine());
	        V = Integer.parseInt(stk.nextToken());
	        E = Integer.parseInt(stk.nextToken());
	        arr = new ArrayList[V + 1];
	        for(int i = 1; i <= V; i++){
	            arr[i] = new ArrayList<Integer>();
	        }
	        
	        for(int i = 0; i < E; i++){
	            stk = new StringTokenizer(br.readLine());
	            int a = Integer.parseInt(stk.nextToken());
	            int b = Integer.parseInt(stk.nextToken());
	            arr[a].add(b);
	            arr[b].add(a);
	        }
	        
	        boolean flag = true;
	        visited = new boolean[V + 1];
	        group = new int[V + 1];
	        
	        for(int i = 1; i <= V; i++){
	            if(visited[i]) continue;
	            visited[i] = true;
	            group[i] = 1;
	            if(!DFS(i, 1)){
	                sb.append("NO\n");
	                flag = false;
	                break;
	            }
	            visited[i] = false;
	        }
	        if(flag) sb.append("YES\n");
	    }
	    
	    System.out.println(sb);
	    
	}
}