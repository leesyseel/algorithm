import java.util.*;
import java.io.*;

class Main{
    
    static class Edge implements Comparable<Edge>{
        int to;
        long dist;
        
        public Edge(int to, long dist){
            this.to = to;
            this.dist = dist;
        }
        
        public int compareTo(Edge o){
            if(this.dist != o.dist){
                return Long.compare(this.dist, o.dist);
            }
            return this.to - o.to;
        }
    }
	
	public static void main (String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        ArrayList<Edge>[] edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            edges[i] = new ArrayList<Edge>();
        }
        
        for(int i = 0; i < m; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            long c = Long.parseLong(stk.nextToken());
            
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }
        
        stk = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());
        
        boolean[] home = new boolean[n + 1];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < p; i++){
            home[Integer.parseInt(stk.nextToken())] = true;
        }
        
        boolean visited[] = new boolean[n + 1];
        long distance[] = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        
        PriorityQueue<Edge> Q = new PriorityQueue<>();
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++){
            int s = Integer.parseInt(stk.nextToken());
            Q.add(new Edge(s, 0));
            distance[s] = 0;
        }
        
        while(!Q.isEmpty()){
            Edge curl = Q.poll();
            if(home[curl.to]){
                System.out.println(curl.to);
                return;
            }
            
            visited[curl.to] = true;
            for(Edge E : edges[curl.to]){
                if(visited[E.to]) continue;
                
                if(distance[E.to] > distance[curl.to] + E.dist){
                    distance[E.to] = distance[curl.to] + E.dist;
                    Q.add(new Edge(E.to, distance[E.to]));
                }
            }
        }
	}
}
