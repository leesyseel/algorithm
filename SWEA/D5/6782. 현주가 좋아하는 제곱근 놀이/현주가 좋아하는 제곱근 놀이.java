import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			long N = 0;
			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				N = N * 10 + (str.charAt(i) - '0');
			}

			long cnt = 0;
			while (N != 2) {
				double root = Math.sqrt(N);
				if (root % 1 == 0) {
					N = (long) Math.sqrt(N);
					cnt++;
				} else {
					long tmp = (long) Math.ceil(root);
					tmp = tmp * tmp;
					cnt += tmp - N;
					N = tmp;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
