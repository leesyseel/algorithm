import java.util.*;
import java.io.*;

class Main{
    
    static class Node implements Comparable<Node>{
        int idx;
        int power;
        
        public Node(int idx, int power){
            this.idx = idx;
            this.power = power;
        }
        
        public int compareTo(Node o){
            return this.power - o.power;
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		
		int[] arrA = new int[N + 1];
		stk = new StringTokenizer(br.readLine());
		for(int i =1; i <= N; i++){
		    arrA[i] = Integer.parseInt(stk.nextToken());
		}
		
		int[] arrB = new int[N + 1];
		stk = new StringTokenizer(br.readLine());
		for(int i =1; i <= N; i++){
		    arrB[i] = Integer.parseInt(stk.nextToken());
		}
		
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer>[] edges = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++){
		    edges[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(stk.nextToken());
		    int b = Integer.parseInt(stk.nextToken());
		    edges[a].add(b);
		    edges[b].add(a);
		}
		
		long res = 0L;
		PriorityQueue<Node> Q = new PriorityQueue<>();
		Q.add(new Node(r, arrA[r]));
		
		while(!Q.isEmpty()){
		    Node curl = Q.poll();
		    if(visited[curl.idx]) continue;
		    if(curl.power > res) continue;
		    
		    visited[curl.idx] = true;
		    res += arrB[curl.idx];
		    
		    for(Integer nxt : edges[curl.idx]){
		        if(visited[nxt]) continue;
		        Q.add(new Node(nxt, arrA[nxt]));
		    }
		}
		
		System.out.println(res);
	}
}
