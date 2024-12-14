import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		int[] nums = new int[N + 1];
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}

		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int lt = 1;
		int rt = 1;
		map.put(nums[1], 1);

		while (rt <= N) {

			if (lt == rt) {
				rt++;
			} else {

				int tmp = map.getOrDefault(nums[rt], 0);

				if (tmp < K) {
					map.put(nums[rt], tmp + 1);
					rt++;
				} else {
					max = max > rt - lt ? max : rt - lt;
					map.put(nums[lt], map.get(nums[lt]) - 1);
					lt++;
				}
			}
		}
		max = max > rt - lt ? max : rt - lt;

		System.out.println(max);
	}
}