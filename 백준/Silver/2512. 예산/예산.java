import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		int lt = 0;
		int rt = 0;

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(stk.nextToken());
			rt = rt > nums[i] ? rt : nums[i];
		}

		int M = Integer.parseInt(br.readLine());
		int res = 0;

		while (lt <= rt) {
			int mid = (lt + rt) / 2;

			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += nums[i] > mid ? mid : nums[i];
			}

			if (sum <= M) {
				res = mid;
				lt = mid + 1;
			} else {
				rt = mid - 1;
			}
		}
		System.out.println(res);
	}
}