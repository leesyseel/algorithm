import java.util.*;
import java.io.*;

class Main{
    
    static int[] parent;
    
    static int find(int n){
        if(parent[n] == n) return n;
        
        return parent[n] = find(parent[n]);
    }
    
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) return false;
        
        if(rootA < rootB){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
        }
        
        return true;
    }
    
    static class Edge implements Comparable<Edge>{
        int from, to;
        double dist;
        
        public Edge(int f, int t, double dist){
            this.from = f;
            this.to = t;
            this.dist = dist;
        }
        
        public int compareTo(Edge o){
            return Double.compare(this.dist, o.dist);
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		parent = new int[N + 1];
		for(int i = 0; i <= N; i++){
		    parent[i] = i;
		}
		
		int[][] points = new int[N + 1][2];
		for(int i = 1; i <= N; i++){
		    stk = new StringTokenizer(br.readLine());
		    points[i][0] = Integer.parseInt(stk.nextToken());
		    points[i][1] = Integer.parseInt(stk.nextToken());
		}
		
		List<Edge> edges = new ArrayList<>();
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int f = Integer.parseInt(stk.nextToken());
		    int t = Integer.parseInt(stk.nextToken());
		    edges.add(new Edge(f, t, 0.0));
		}
		
		for(int i = 1; i <= N; i++){
		    for(int j = i + 1; j <= N; j++){
		        double dx = points[i][0] - points[j][0];
		        double dy = points[i][1] - points[j][1];
		        double dist = Math.sqrt(dx * dx + dy * dy);
		        edges.add(new Edge(i, j, dist));
		    }
		}
		Collections.sort(edges);
		
		double sum = 0;
		for(Edge curl : edges){
		    int f = curl.from;
		    int c = curl.to;
		    double dist = curl.dist;
		    
		    if(union(f, c)){
		        sum += dist;
		    }
		}
		System.out.printf("%.2f", sum);
	}
}
