import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int[] deltas = { 0, -1, 10, 1, -10 };
	static int[] moveA, moveB;
	static int[][] charger;
	static int M, C;

	static int score(int A, int B, int sumA, int sumB) {

		for (int sec = 0; sec <= M; sec++) {

			A += deltas[moveA[sec]];
			B += deltas[moveB[sec]];

			if (A == B) {

				int[] arr = new int[2];
				int cnt = 0;
				for (int i = 1; i <= C; i++) {
					if (find_power(A, i))
						arr[cnt++] = i;
					if (cnt == 2)
						break;
				}

				if (cnt >= 2) {
					sumA += charger[arr[0]][2];
					sumB += charger[arr[1]][2];
				} else if (cnt == 1) {
					sumA += charger[arr[0]][2] / 2;
					sumB += charger[arr[0]][2] / 2;
				}

			} else { // A!=B

				int idxA = 0, idxB = 0;
				for (int i = 1; i <= C; i++) {
					if (find_power(A, i)) {
						idxA = i;
						break;
					}
				}
				for (int i = 1; i <= C; i++) {
					if (find_power(B, i)) {
						idxB = i;
						break;
					}
				}

				if (idxA == idxB) {
					if (idxA != 0) { // A와 B의 위치가 다른데 같은 영역인 경우

						int othA = 0, othB = 0;
						for (int i = idxA + 1; i <= C; i++) {
							if (find_power(A, i)) {
								othA = i;
								break;
							}
						}
						for (int i = idxB + 1; i <= C; i++) {
							if (find_power(B, i)) {
								othB = i;
								break;
							}
						}

						if (othA == 0 && othB == 0) {
							sumA += charger[idxA][2] / 2;
							sumB += charger[idxA][2] / 2;

						} else if (othA == 0 && othB != 0) {
							sumA += charger[idxA][2];
							sumB += charger[othB][2];

						} else if (othA != 0 && othB == 0) {
							sumA += charger[othA][2];
							sumB += charger[idxA][2];

						} else {
							if (othA < othB) {
								sumA += charger[othA][2];
								sumB += charger[idxA][2];

							} else {
								sumA += charger[idxA][2];
								sumB += charger[othB][2];

							}

						}
					} // A와 B의 위치가 다른데 같은 영역인 경우 end

				} else { // idxA!=idxB
					if (idxA != 0) {
						sumA += charger[idxA][2];
					}

					if (idxB != 0) {
						sumB += charger[idxB][2];
					}
				}

			} // A!=B end

		}

		return sumA + sumB;

	}

	static boolean find_power(int person, int cg_idx) {

		int loc = charger[cg_idx][0];
		int dist = Math.abs(loc / 10 - person / 10) + Math.abs(loc % 10 - person % 10);
		if (dist <= charger[cg_idx][1]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk1, stk2;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			stk1 = new StringTokenizer(br.readLine());
			M = Integer.parseInt(stk1.nextToken()); // 총 이동 시간
			C = Integer.parseInt(stk1.nextToken()); // BC 개수

			moveA = new int[M + 1];
			moveB = new int[M + 1];
			stk1 = new StringTokenizer(br.readLine());
			stk2 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(stk1.nextToken());
				moveB[i] = Integer.parseInt(stk2.nextToken());
			}

			charger = new int[C + 1][3];
			for (int i = 1; i <= C; i++) {
				stk1 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stk1.nextToken());
				int y = Integer.parseInt(stk1.nextToken());

				charger[i][0] = 10 * (x - 1) + (y - 1); // 배터리 위치
				charger[i][1] = Integer.parseInt(stk1.nextToken()); // 배터리 영향 범위
				charger[i][2] = Integer.parseInt(stk1.nextToken()); // 배터리 파워

			}

			charger[0][2] = 600;
			Arrays.sort(charger, (o1, o2) -> -1 * (o1[2] - o2[2]));

			int A = 0, B = 99;
			score(A, B, 0, 0);

			sb.append(score(A, B, 0, 0)).append("\n");

		}
		System.out.println(sb);

	}

}