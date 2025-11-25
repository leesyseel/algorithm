import java.util.*;
class Solution {
    
    static class Edge implements Comparable<Edge>{
        int to;
        int val;
        
        public Edge(int to, int val){
            this.to = to;
            this.val = val;
        }
        
        public int compareTo(Edge o){
            return this.val - o.val;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;
            
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        ArrayList<Edge>[] list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            dist[i] = INF;
            list[i] = new ArrayList<Edge>();
        }
        
        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        
        Queue<Edge> Q = new PriorityQueue<>();
        Q.add(new Edge(1, 0));
        dist[1] = 0;
        
        while(!Q.isEmpty()){
            Edge curl = Q.poll();
            
            if(visited[curl.to]) continue;
            visited[curl.to] = true;
            
            for(Edge E : list[curl.to]){
                if(visited[E.to]) continue;
                
                if(dist[E.to] > dist[curl.to] + E.val){
                    dist[E.to] = dist[curl.to] + E.val;
                    Q.add(new Edge(E.to, dist[E.to]));
                }
            }
        }
        
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
}