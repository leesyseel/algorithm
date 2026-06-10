import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int idx;
        int cost;
        
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        int INF = Integer.MAX_VALUE;
        int m = sources.length;
        int[] answer = new int[m];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            edges[i] = new ArrayList<Integer>();
        }
        
        for(int[] tmp : roads){
            edges[tmp[0]].add(tmp[1]);
            edges[tmp[1]].add(tmp[0]);
        }
        
        dist[destination] = 0;
        pq.offer(new Node(destination, 0));
        
        while(!pq.isEmpty()){
            Node curl = pq.poll();
            if(visited[curl.idx]) continue;
            visited[curl.idx] = true;
            
            for(int nxt : edges[curl.idx]){
                if(dist[nxt] > curl.cost + 1){
                    dist[nxt] = curl.cost + 1;
                    pq.add(new Node(nxt, dist[nxt]));
                }
            }            
        }
        
        for(int i = 0; i < m; i++){
            answer[i] = dist[sources[i]] == INF ? -1 : dist[sources[i]];
        }      
        
        return answer;
    }
}