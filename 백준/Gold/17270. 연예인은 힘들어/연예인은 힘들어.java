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
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int INF = 1000000;
		
		stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[] distJ = new int[V + 1];
		int[] distS = new int[V + 1];
		
		ArrayList<Edge>[] edges = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++){
		    edges[i] = new ArrayList<Edge>();
		    distJ[i] = distS[i] = INF;
		}
		
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(stk.nextToken());
		    int b = Integer.parseInt(stk.nextToken());
		    int c = Integer.parseInt(stk.nextToken());
		    
		    edges[a].add(new Edge(b, c));
		    edges[b].add(new Edge(a, c));
		}
		
		stk = new StringTokenizer(br.readLine());
		int idxJ = Integer.parseInt(stk.nextToken());
		int idxS = Integer.parseInt(stk.nextToken());
		
		PriorityQueue<Edge> Q = new PriorityQueue<>();
		boolean[] visitedJ = new boolean[V + 1];
		boolean[] visitedS = new boolean[V + 1];
		
		// distJ 갱신
		Q.add(new Edge(idxJ, 0));
		distJ[idxJ] = 0;
		
		while(!Q.isEmpty()){
		    Edge curl = Q.poll();
		    
		    if(visitedJ[curl.to]) continue;
		    visitedJ[curl.to] = true;
		    
		    for(Edge E : edges[curl.to]){
		        if(visitedJ[E.to]) continue;
		        if(distJ[E.to] > curl.val + E.val){
		            distJ[E.to] = curl.val + E.val;
		            Q.add(new Edge(E.to, distJ[E.to]));
		        }
		    }
		}
		
		// distS 갱신
		Q.clear();
		Q.add(new Edge(idxS, 0));
		distS[idxS] = 0;
		
		while(!Q.isEmpty()){
		    Edge curl = Q.poll();
		    
		    if(visitedS[curl.to]) continue;
		    visitedS[curl.to] = true;
		    
		    for(Edge E : edges[curl.to]){
		        if(visitedS[E.to]) continue;
		        if(distS[E.to] > curl.val + E.val){
		            distS[E.to] = curl.val + E.val;
		            Q.add(new Edge(E.to, distS[E.to]));
		        }
		    }
		}
		
		int resIdx = INF;
		int minSum = INF;
		int resJ = INF;
		for(int i = 1; i <= V; i++){
		    // 1번 조건 제거
		    if(i == idxJ || i == idxS) continue;
		    
		    // 최소 거리 갱신
		    int tmpS = distJ[i] + distS[i];
		    if(minSum > tmpS){
		        minSum = tmpS;
		        resIdx = resJ = INF;
		    }
		    
		    // 2번 조건 제거
		    if(minSum == tmpS){
		        // 3번 조건 제거
		        if(distJ[i] <= distS[i]){
		            if(resJ > distJ[i]){ // 4-1 조건
		                resJ = distJ[i];
		                resIdx = i;
		            }else if(resJ == distJ[i]){ // 4-2 조건
		                resIdx = Math.min(resIdx, i);
		            }
		        }
		    }
		    
		}
		if(resIdx == INF) resIdx = -1;
		System.out.println(resIdx);
	}
}
