import java.util.*;
import java.io.*;

class Main{
    
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
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		boolean[] visited = new boolean[N + 1];
		ArrayList<Edge>[] list = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++){
		    list[i] = new ArrayList<Edge>();
		}
		
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(stk.nextToken());
		    int b = Integer.parseInt(stk.nextToken());
		    int c = Integer.parseInt(stk.nextToken());
		    
		    list[a].add(new Edge(b, c));
		    list[b].add(new Edge(a, c));
		}
		
		PriorityQueue<Edge> Q = new PriorityQueue<>();
		Q.add(new Edge(1, 0));
		int res = 0;
		
		while(!Q.isEmpty()){
		    Edge curl = Q.poll();
		    int node = curl.to;
		    int c = curl.val;
		    
		    if(node == N){
		        res = c;
		        break;
		    }
		    
		    if(visited[node]) continue;
		    visited[node] = true;
		    
		    
		    for(Edge nxt : list[node]){
		        Q.add(new Edge(nxt.to, c + nxt.val));
		    }
		}
		
		System.out.println(res);
	}
}
