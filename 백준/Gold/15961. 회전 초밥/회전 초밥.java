import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());

		int[] dish = new int[N + k - 1];
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k - 1; i++) {
			dish[i] = dish[i - N];
		}

		int[] sushi = new int[d + 1];
		for (int i = 0; i < k; i++) {
			int s = dish[i];
			if (sushi[s] == 0)
				sushi[0]++;
			sushi[s]++;
		}

		int max = sushi[0];
		if (sushi[c] == 0)
			max++;

		for (int i = 1; i < N; i++) {
			if (--sushi[dish[i - 1]] == 0)
				sushi[0]--;
			if (sushi[dish[i + k - 1]]++ == 0)
				sushi[0]++;

			int tmp = sushi[0];
			if (sushi[c] == 0)
				tmp++;

			max = Math.max(max, tmp);
		}

		System.out.println(max);
	}
}
