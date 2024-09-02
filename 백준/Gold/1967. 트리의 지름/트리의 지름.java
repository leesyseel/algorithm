import java.io.*;
import java.util.*;

public class Main {

	static int result, N, farNode;
	static int[][] graph;
	static boolean[] visit;
	static List<Node>[] nList;

	static void DFS(int node, int sum) {

		boolean flag = true;

		for (int i = 0; i < nList[node].size(); i++) {

			Node nxt = nList[node].get(i);
			if (visit[nxt.num]) continue;

			flag = false;
			visit[nxt.num] = true;
			DFS(nxt.num, sum + nxt.cost);
			visit[nxt.num] = false;
		}

		if (flag) {
			if (result < sum) {
				result = sum;
				farNode = node;
			}
		}
	}

	static class Node {
		int num, cost;

		public Node(int num, int cost) {
			super();
			this.num = num;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		N = Integer.parseInt(br.readLine());
		nList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			nList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			nList[a].add(new Node(b, c));
			nList[b].add(new Node(a, c));
		}

		result = 0;
		visit = new boolean[N + 1];
		visit[1] = true;
		farNode = 1;
		DFS(1, 0);
		visit[1] = false;

		visit[farNode] = true;
		DFS(farNode, 0);

		System.out.println(result);

	}
}
