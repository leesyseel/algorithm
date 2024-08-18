import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int result;

	static void nQueen(int idx, int N, int[] location) {
		if (idx == N) {
			result++;
		} else {
			for (int i = 0; i < N; i++) {
				if (idx == 0) {
					location[idx] = i;
					nQueen(idx + 1, N, location);
				} else {
					boolean flag = false;
					for (int j = 0; j < idx; j++) {
						if (location[j] == i || Math.abs(location[j] - i) == Math.abs(j - idx)) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						location[idx] = i;
						nQueen(idx + 1, N, location);
					}
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] location = new int[N];

		result = 0;
		nQueen(0, N, location);

		System.out.println(result);
	}

}