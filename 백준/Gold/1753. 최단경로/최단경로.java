import java.io.*;
import java.util.*;

public class Main {

	static class Vertex implements Comparable<Vertex> {
		int to;
		long cost;

		public Vertex(int to, long cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost,o.cost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());

		List<Vertex>[] vList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			vList[i] = new ArrayList<>();
		}

		int start = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			vList[f].add(new Vertex(t, c));
		}

		long[] dist = new long[V + 1];
		boolean[] visit = new boolean[V + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		Queue<Vertex> Q = new PriorityQueue<>();
		Q.add(new Vertex(start, 0));
		dist[start] = 0L;

		while (!Q.isEmpty()) {

			Vertex curl = Q.poll();
			
			if (visit[curl.to]) continue;

			visit[curl.to] = true;

			for (Vertex v : vList[curl.to]) {
				if (visit[v.to]) continue;

				if (dist[v.to] > dist[curl.to] + v.cost) {
					dist[v.to] = dist[curl.to] + v.cost;
					Q.add(new Vertex(v.to, dist[v.to]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {

			if (dist[i] == Long.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i]).append("\n");

		}
		System.out.println(sb);

	}
}
