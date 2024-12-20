import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int to;
		long cost;
		int leftK;

		public Node(int to, long cost, int leftK) {
			this.to = to;
			this.cost = cost;
			this.leftK = leftK;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		ArrayList<Node>[] edge = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken()) - 1;
			int to = Integer.parseInt(stk.nextToken()) - 1;
			int v = Integer.parseInt(stk.nextToken());
			edge[from].add(new Node(to, v, K));
			edge[to].add(new Node(from, v, K));
		}

		long[][] map = new long[N][K + 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], Long.MAX_VALUE);
		}

		Queue<Node> Q = new PriorityQueue<>();
		Q.add(new Node(0, 0L, K));
		map[0][K] = 0;
		while (!Q.isEmpty()) {
			Node curl = Q.poll();
			
			if (curl.to == N - 1) break;
			if(curl.cost > map[curl.to][curl.leftK]) continue;
			
			for (Node Nd : edge[curl.to]) {
				long c = curl.cost + Nd.cost;
				if (map[Nd.to][curl.leftK] > c) {
					map[Nd.to][curl.leftK] = c;
					Q.add(new Node(Nd.to, c, curl.leftK));
				}

				if (curl.leftK > 0 && map[Nd.to][curl.leftK - 1] > curl.cost) {
					map[Nd.to][curl.leftK - 1] = curl.cost;
					Q.add(new Node(Nd.to, curl.cost, curl.leftK - 1));
				}
			}
		}
		
		long res = Long.MAX_VALUE;
		for(int i = 0; i <= K ; i++) {
			res = res < map[N - 1][i] ? res : map[N - 1][i];
		}
		System.out.println(res);
	}
}