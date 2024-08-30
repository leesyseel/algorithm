
import java.io.*;
import java.util.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge o) {

			return this.weight - o.weight;
		}
	}

	static int[] parent;

	static void make(int n) {
		for (int i = 1; i <= n; i++) {
			parent[i] = -1;
		}
	}

	static boolean union(int a, int b) {

		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return false;

		if (rootA < rootB) {
			parent[rootA] += parent[rootB];
			parent[rootB] = rootA;
		} else {
			parent[rootB] += parent[rootA];
			parent[rootA] = rootB;
		}
		return true;
	}

	static int find(int n) {

		if (parent[n] < 0)
			return n;

		return parent[n] = find(parent[n]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		parent = new int[V + 1];
		make(V);

		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());

			edges[i] = new Edge(f, t, w);
		}

		Arrays.sort(edges);

		long cnt = 0, result = 0;

		for (int i = 0; i < E; i++) {
			int f = edges[i].from;
			int t = edges[i].to;
			int w = edges[i].weight;

			if (union(f, t)) {
				result += w;
				if (++cnt == V - 1)
					break;
			}
		}

		System.out.println(result);

	}
}
