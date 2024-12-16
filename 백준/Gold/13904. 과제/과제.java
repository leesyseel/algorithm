import java.io.*;
import java.util.*;

public class Main {

	static class Subject implements Comparable<Subject> {
		int deadLine;
		int score;

		public Subject(int deadLine, int score) {
			this.deadLine = deadLine;
			this.score = score;
		}

		@Override
		public int compareTo(Subject o) {
			if (this.score != o.score)
				return Integer.compare(this.score, o.score) * (-1);
			else
				return Integer.compare(this.deadLine, o.deadLine);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		int n = Integer.parseInt(br.readLine());
		List<Subject> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			list.add(new Subject(d, w));
		}
		Collections.sort(list);

		int total = 0;
		boolean[] check = new boolean[1001];
		for (Subject S : list) {

			for (int i = S.deadLine; i > 0; i--) {
				if (!check[i]) {
					total += S.score;
					check[i] = true;
					break;
				}
			}
		}
		System.out.println(total);
	}
}