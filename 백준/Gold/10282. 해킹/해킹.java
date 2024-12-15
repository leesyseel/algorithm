import java.util.*;
import java.io.*;

public class Main {

	static class Computer implements Comparable<Computer> {
		int to;
		long time;

		public Computer(int to, long time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Computer o) {
			return Long.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			List<Computer>[] list = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
			}

			while (d-- > 0) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				int s = Integer.parseInt(stk.nextToken());

				list[b].add(new Computer(a, s));
			}

			boolean[] visit = new boolean[n + 1];
			long[] dist = new long[n + 1];
			Arrays.fill(dist, Long.MAX_VALUE);

			Queue<Computer> Q = new PriorityQueue<>();
			Q.add(new Computer(c, 0));
			dist[c] = 0L;

			while (!Q.isEmpty()) {

				Computer curl = Q.poll();

				if (visit[curl.to]) continue;
				visit[curl.to] = true;

				for (Computer C : list[curl.to]) {

					if (!visit[C.to] && (dist[C.to] > dist[curl.to] + C.time)) {
						dist[C.to] = dist[curl.to] + C.time;
						Q.add(new Computer(C.to, dist[C.to]));
					}
				}
			}

			int cnt = 0;
			long res = 0;

			for (int i = 0; i <= n; i++) {
				if (!visit[i]) continue;

				res = res > dist[i] ? res : dist[i];
				cnt++;
			}
			sb.append(cnt).append(" ").append(res).append("\n");

		}
		System.out.println(sb);
	}
}