import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> Q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			Q.add(Integer.parseInt(br.readLine()));
		}

		int res = 0;
		while (Q.size() > 1) {
			int a = Q.poll();
			int b = Q.poll();
			res += a + b;
			Q.add(a + b);
		}
		System.out.println(res);
	}
}