import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		int max = Integer.MIN_VALUE;
		int min = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(stk.nextToken());
			if (tree[i] > max)
				max = tree[i];

		}

		int result = 0;

		while (min <= max) {
			int mid = (min + max) / 2;
			long s = 0;
			for (int i = 0; i < N; i++) {
				if (tree[i] > mid) {
					s += tree[i] - mid;
				}
			}
			
			if (s >= M) {
				result = mid;
				min = mid + 1;
			} else if (s < M) {
				max = mid - 1;
			}

		}
		System.out.println(result);
	}

}
