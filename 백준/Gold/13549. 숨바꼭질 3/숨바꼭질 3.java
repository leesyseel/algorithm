
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		if (K < N) {
			System.out.println(N - K);
		} else {
			Queue<Integer> Q = new ArrayDeque<>();
			boolean[] check = new boolean[100001];
			int[] time = new int[100001];

			check[N] = true;
			Q.add(N);

			while (!Q.isEmpty()) {

				int idx = Q.poll();

				if (idx == K)
					break;

				int tmp = idx * 2;
				while (tmp <= 100000 && !check[tmp]) {
					time[tmp] = time[idx];
					check[tmp] = true;
					Q.add(tmp);
				}

				if (idx - 1 >= 0 && !(check[idx - 1])) {
					check[idx - 1] = true;
					time[idx - 1] = time[idx] + 1;
					Q.add(idx - 1);
				}

				if (idx + 1 <= 100000 && !(check[idx + 1])) {
					check[idx + 1] = true;
					time[idx + 1] = time[idx] + 1;
					Q.add(idx + 1);
				}

			}

			System.out.println(time[K]);
		}
	}

}