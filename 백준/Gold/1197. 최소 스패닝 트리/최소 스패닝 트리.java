import java.io.*;
import java.util.*;

public class Main {
	
	static class Vertex implements Comparable<Vertex>{
		int to;
		int cost;
		
		public Vertex(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());
		
		List<Vertex>[] vList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			vList[i]=new ArrayList<Vertex>();
		}
		
		for(int i=0;i<E;i++) {
			stk = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(stk.nextToken());
			int t =Integer.parseInt(stk.nextToken());
			int c =Integer.parseInt(stk.nextToken());
			
			vList[f].add(new Vertex(t, c));
			vList[t].add(new Vertex(f, c));
		}
		
		Queue<Vertex> Q = new PriorityQueue<Vertex>();
		boolean[] visit = new boolean[V+1];
		long result=0;
		
		Q.add(new Vertex(1, 0));
		
		while(!Q.isEmpty()) {
			
			Vertex curl = Q.poll();
			
			if(visit[curl.to]) continue;
			
			visit[curl.to]=true;
			result+=curl.cost;
			
			for(int i=0;i<vList[curl.to].size();i++) {
				Q.add(vList[curl.to].get(i));
			}
		}
		
		System.out.println(result);

	}
}
