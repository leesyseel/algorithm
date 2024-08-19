import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int max, min;

    static void calc(int idx, int num, int N, int[] nums, int[] oper) {
        if (idx == N) {
            if (num > max) max = num;
            if (num < min) min = num;
        } else {
            for (int i = 0; i < 4; i++) {
                if (oper[i] > 0) {
                    oper[i]--;
                    int tmp = real_calc(i, num, nums[idx]);
                    calc(idx + 1, tmp, N, nums, oper);
                    oper[i]++;
                }
            }
        }
    }

    static int real_calc(int i, int n1, int n2) {
        switch (i) {
            case 0:
                return n1 + n2;
            case 1:
                return n1 - n2;
            case 2:
                return n1 * n2;
            case 3:
                return n1 / n2;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            int N = Integer.parseInt(br.readLine());

            int[] oper = new int[4];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                oper[i] = Integer.parseInt(stk.nextToken());
            }

            int[] nums = new int[N];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(stk.nextToken());
            }

            calc(1, nums[0], N, nums, oper);
            sb.append((max - min) + "\n");
        }
        System.out.println(sb);
    }// end main
}
