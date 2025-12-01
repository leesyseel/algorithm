import java.util.*;
import java.io.*;

class Main{
    
    static class Node implements Comparable<Node>{
        int to;
        int val;
        
        public Node(int to, int val){
            this.to = to;
            this.val = val;
        }
        
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int X = Integer.parseInt(stk.nextToken());
		int INF = 1000 * 1000;
		
		boolean[] fromVisited = new boolean[n + 1];
		boolean[] toVisited = new boolean[n + 1];
		int[] fromDist = new int[n + 1];
		int[] toDist = new int[n + 1];
		
		ArrayList<Node>[] toEdges = new ArrayList[n + 1];
		ArrayList<Node>[] fromEdges = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++){
		    toEdges[i] = new ArrayList<Node>();
		    fromEdges[i] = new ArrayList<Node>();
		    fromDist[i] = toDist[i] = INF;
		}
		fromDist[X] = toDist[X] = 0;
		
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int f = Integer.parseInt(stk.nextToken());
		    int t = Integer.parseInt(stk.nextToken());
		    int v = Integer.parseInt(stk.nextToken());
		    
		    toEdges[f].add(new Node(t, v));
		    fromEdges[t].add(new Node(f, v));
		}
		
		
		
		PriorityQueue<Node> Q = new PriorityQueue<>();
		Q.add(new Node(X, 0));
		
		while(!Q.isEmpty()){
		    Node curl = Q.poll();
		    if(toVisited[curl.to]) continue;
		    
		    toVisited[curl.to] = true;
		    
		    for(Node N : toEdges[curl.to]){
		        if(toVisited[N.to]) continue;
		        
		        if(toDist[N.to] > N.val + curl.val){
		            toDist[N.to] = N.val + curl.val;
		            Q.add(new Node(N.to, toDist[N.to]));
		        }
		    }
		}
		
		Q.clear();
		Q.add(new Node(X, 0));
		
		while(!Q.isEmpty()){
		    Node curl = Q.poll();
		    if(fromVisited[curl.to]) continue;
		    
		    fromVisited[curl.to] = true;
		    
		    for(Node N : fromEdges[curl.to]){
		        if(fromVisited[N.to]) continue;
		        
		        if(fromDist[N.to] > N.val + curl.val){
		            fromDist[N.to] = N.val + curl.val;
		            Q.add(new Node(N.to, fromDist[N.to]));
		        }
		    }
		}
		
		int max = 0;
		for(int i = 1; i <= n; i++){
		    max = Math.max(fromDist[i] + toDist[i], max);
		}
		System.out.println(max);
	}
}