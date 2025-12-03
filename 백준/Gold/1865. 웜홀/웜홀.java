import java.util.*;
import java.io.*;

class Main{
    
    static int INF = 1000000000;
    static int N;
    static ArrayList<Edge>[] edges;
    
    static class Edge{
        int to;
        int val;
        
        public Edge(int to, int val){
            this.to = to;
            this.val = val;
        }
    }
    
    static boolean solve(){
        
        int[] dist = new int[N + 1];
	    Arrays.fill(dist, INF);
	    dist[1] = 0;
        
        for(int t = 1; t <= N; t++){
            for(int i = 1; i <= N; i++){
                for(Edge E : edges[i]){
                    if(dist[E.to] > dist[i] + E.val){
                        dist[E.to] = dist[i] + E.val;
                        if(t == N) return true;
                    }   
                }
            }
        }
        return false;
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
	    int TC = Integer.parseInt(br.readLine());
	    while(TC-- > 0){
	        stk = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(stk.nextToken());
	        int M = Integer.parseInt(stk.nextToken());
	        int W = Integer.parseInt(stk.nextToken());
	        
	        edges = new ArrayList[N + 1];
	        for(int i = 1; i <= N; i++){
	            edges[i] = new ArrayList<>();
	        }
	        
	        // 도로
	        for(int i = 0; i < M; i++){
	            stk = new StringTokenizer(br.readLine());
	            int s = Integer.parseInt(stk.nextToken());
	            int e = Integer.parseInt(stk.nextToken());
	            int t = Integer.parseInt(stk.nextToken());
	            
	            edges[s].add(new Edge(e, t));
	            edges[e].add(new Edge(s, t));
	        }
	        // 웜홀
	        for(int i = 0; i < W; i++){
	            stk = new StringTokenizer(br.readLine());
	            int s = Integer.parseInt(stk.nextToken());
	            int e = Integer.parseInt(stk.nextToken());
	            int t = -1 * Integer.parseInt(stk.nextToken());
	            edges[s].add(new Edge(e, t));
	        }
	        String res = "NO";
	        if(solve()) res = "YES";
	        sb.append(res + "\n");
	    }
		System.out.println(sb);
	}
}
