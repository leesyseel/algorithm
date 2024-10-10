
import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] pt, gear;

	static void spin(int before, int num, int dir) {
		int lt = pt[num][1];
		int rt = pt[num][0];

		// 연쇄 작용
		if (num - 1 >= 0) {
			int frt = pt[num - 1][0];
			if (num - 1 != before && gear[num][lt] != gear[num - 1][frt])
				spin(num, num - 1, (dir + 1) % 2);
		}
		if (num + 1 < 4) {
			int flt = pt[num + 1][1];
			if (num + 1 != before && gear[num][rt] != gear[num + 1][flt])
				spin(num, num + 1, (dir + 1) % 2);
		}

		// 회전
		if (dir == 1) {
			pt[num][1] = (lt + 7) % 8;
			pt[num][0] = (rt + 7) % 8;

		} else {
			pt[num][1] = (lt + 1) % 8;
			pt[num][0] = (rt + 1) % 8;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		String strA = br.readLine();
		String strB = br.readLine();
		String strC = br.readLine();
		String strD = br.readLine();

		gear = new int[4][8];

		for (int i = 0; i < 8; i++) {
			gear[0][i] = strA.charAt(i) - '0';
			gear[1][i] = strB.charAt(i) - '0';
			gear[2][i] = strC.charAt(i) - '0';
			gear[3][i] = strD.charAt(i) - '0';
		}

		pt = new int[4][2];
		for (int i = 0; i < 4; i++) {
			pt[i][0] = 2; // rt
			pt[i][1] = 6; // lt
		}

		int K = Integer.parseInt(br.readLine());

		while (K-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(stk.nextToken()) - 1;
			int dir = Integer.parseInt(stk.nextToken());

			if (dir == -1)
				dir = 0;
			spin(-1, num, dir);
		}

		int result = 0;
		for (int i = 0; i < 4; i++) {

			int idx = (pt[i][0] + 6) % 8;
			result += (1 << i) * gear[i][idx];
		}
		System.out.println(result);
	}
}
