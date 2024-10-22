import java.util.*;
import java.io.*;

public class Main {

	static class Tree implements Comparable<Tree>{
		int r, c;
		int age;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.age, o.age);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		int[][] delta = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

		LinkedList<Tree> Q = new LinkedList<>();
		LinkedList<Tree> baby = new LinkedList<>();
		int[][] food = new int[N][N];
		int[][] A = new int[N][N];
		int[][] death = new int[N][N];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				food[i][j] = 5;
				A[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		while (M-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken()) - 1;
			int y = Integer.parseInt(stk.nextToken()) - 1;
			int z = Integer.parseInt(stk.nextToken());

			Q.add(new Tree(x, y, z));
		}
		
		Collections.sort(Q);

		while (K-- > 0) {

			int L = Q.size();
			if (L == 0)
				break;

			while (L-- > 0) {

				Tree T = Q.poll();
				int r = T.r;
				int c = T.c;
				int age = T.age;

				// summer
				if (age > food[r][c]) {
					death[r][c] += age / 2;
					continue;
				}

				// spring
				food[r][c] -= age;
				age++;
				Q.add(new Tree(r, c, age));

				// fall
				if (age % 5 == 0) {
					for (int d = 0; d < 8; d++) {
						int nr = r + delta[d][0];
						int nc = c + delta[d][1];

						if (nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;
						baby.add(new Tree(nr, nc, 1));
					}
				}
			}
			
			for(Tree T:baby) {
				Q.addFirst(T);
			}
			baby.clear();
			
			// winter
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					food[i][j] += death[i][j] + A[i][j];
					death[i][j] = 0;
				}
			}
		}
		System.out.println(Q.size());
	}
}