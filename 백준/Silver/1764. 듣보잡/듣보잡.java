import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		Map<String, Integer> notH = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			notH.put(br.readLine(), 1);
		}

		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (notH.get(tmp) != null) {
				notH.replace(tmp, 0);
			}
		}

		int cnt = 0;
		for (String key : notH.keySet()) {
			if (notH.get(key) == 0) {
				sb.append(key + "\n");
				cnt++;
			}
		}

		sb.insert(0, cnt + "\n");
		System.out.println(sb);

	}
}
