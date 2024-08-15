import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int[] zero = new int[N + 2];
			int[] one = new int[N + 2];

			zero[0] = 1;	zero[1] = 0;
			one[0] = 0;		one[1] = 1;

			for (int i = 2; i < N + 1; i++) {
				zero[i] = zero[i - 2] + zero[i - 1];
				one[i] = one[i - 2] + one[i - 1];
			}
			sb.append(zero[N] + " " + one[N] + "\n");

		}
		System.out.println(sb);

	}

}
