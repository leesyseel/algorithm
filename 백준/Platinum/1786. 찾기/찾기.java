import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		// 부분 일치 테이블 pi 만들기
		int[] pi = new int[P.length];
		int j = 0;

		for (int i = 1; i < P.length; i++) {
			if (P[i] == P[j]) {
				pi[i] = ++j;
			} else {
				if (j == 0) {
					pi[i] = 0;
				} else {
					j = pi[j - 1];
					i--;
				}
			}
		}

		// KMP 구현
		int cnt = 0;
		j = 0;

		for (int i = 0; i < T.length; i++) {
			if (P[j] == T[i]) {
				if (++j == P.length) {
					j--;
					cnt++;
					sb.append(i - j + 1 + " ");
					if (j != 0) {
						j = pi[j - 1];
						i--;
					}

				}
			} else {
				if (j != 0) {
					j = pi[j - 1];
					i--;
				}
			}
		}

		System.out.println(cnt);
		System.out.println(sb);
	}
}