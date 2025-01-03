import java.util.*;
import java.io.*;

public class Solution {
    static final int INF = Integer.MAX_VALUE;
    
    static class Edge implements Comparable<Edge>{
    	int to;
    	int cost;
    	
    	public Edge(int to, int cost) {
    		this.to = to;
    		this.cost = cost;
    	}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
    }
    
    public static void solve(int start, List<Edge>[] list, int[] dist) {
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
        	Edge curl = pq.poll();
        	
        	if(curl.cost > dist[curl.to]) continue;
        	
        	for(Edge next : list[curl.to]) {
        		int tmp = next.cost + curl.cost;
        		if(dist[next.to] > tmp) {
        			dist[next.to] = tmp;
        			pq.add(new Edge(next.to, tmp));
        		}
        	}
        }
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer stk;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	
        	stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            int X = Integer.parseInt(stk.nextToken());
            
            List<Edge>[] list = new ArrayList[N + 1];
            List<Edge>[] listRv = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
                listRv[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
            	stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                int c = Integer.parseInt(stk.nextToken());
                
                list[x].add(new Edge(y, c));
                listRv[y].add(new Edge(x, c));
            }
            
            // X에서 다른 정점까지의 최단 경로
            int[] fromDist = new int[N + 1];
            Arrays.fill(fromDist, INF);
            fromDist[X] = 0;
            solve(X, list, fromDist);
            
            // 다른 정점에서 X까지의 최단 경로
            int[] toDist = new int[N + 1];
            Arrays.fill(toDist, INF);
            toDist[X] = 0;
            solve(X, listRv, toDist);
            
            int res = 0;
            for(int i = 1; i <= N ; i++) {
            	res = Integer.max(res, fromDist[i] + toDist[i]);
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
}
