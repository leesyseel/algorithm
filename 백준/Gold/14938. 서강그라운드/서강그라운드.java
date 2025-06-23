import java.util.*;
import java.io.*;

public class Main{
    
    static int n, m;
    static int[] items;
    static List<Edge>[] edges;
    
    public static class Edge implements Comparable<Edge> {
        int to;
        int dist;
        
        public Edge(int to, int dist){
            this.to = to;
            this.dist = dist;
        }
        
        public int compareTo(Edge o){
            return this.dist - o.dist;
        }
    }
    
    static int solve(int idx){
        PriorityQueue<Edge> Q = new PriorityQueue<>();
        Q.add(new Edge(idx, 0));
        int cnt = 0;
        boolean[] visit = new boolean[n + 1];
        
        while(!Q.isEmpty()){
            Edge curl = Q.poll();
            if(visit[curl.to]) continue;
            
            visit[curl.to] = true;
            cnt += items[curl.to];
            
            for(Edge E : edges[curl.to]){
                if(visit[E.to] || curl.dist + E.dist > m) continue;
                Q.add(new Edge(E.to, curl.dist + E.dist));
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        
        items = new int[n + 1];
        edges = new ArrayList[n + 1];
        
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            items[i] = Integer.parseInt(stk.nextToken());
            edges[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < r; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());
            edges[a].add(new Edge(b, d));
            edges[b].add(new Edge(a, d));
        }
        
        int res = 0;
        for(int i = 1; i <= n; i++){
            int tmp = solve(i);
            res = res > tmp ? res : tmp;
        }
        System.out.println(res);
    }
}