
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb;

	static void DFS(int sidx, int arridx, int mo, int ja, int C, int L, char[] alpha, char[] arr) {
		if (arridx == L) {
			if (mo >= 1 && ja >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(arr[i]);
				}
				sb.append("\n");
			}
		} else {
			for (int i = sidx; i < C; i++) {
				arr[arridx] = alpha[i];
				if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
					DFS(i + 1, arridx + 1, mo + 1, ja, C, L, alpha, arr);
				} else {
					DFS(i + 1, arridx + 1, mo, ja + 1, C, L, alpha, arr);
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		char[] alpha = new char[C];
		for (int i = 0; i < C; i++) {
			alpha[i] = stk.nextToken().charAt(0);
		}
		Arrays.sort(alpha);

		char[] arr = new char[L];

		DFS(0, 0, 0, 0, C, L, alpha, arr);

		System.out.println(sb);
	}
}
