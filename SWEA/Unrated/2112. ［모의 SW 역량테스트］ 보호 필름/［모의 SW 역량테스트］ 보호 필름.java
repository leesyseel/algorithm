import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
    static int result;
 
    static boolean check(int D, int W, int K, int[][] map) {
        for (int c = 0; c < W; c++) {
            int num = map[0][c];
            int L = 1;
            for (int r = 1; r < D; r++) {
                if (map[r][c] == num) {
                    L++;
                } else {
                    num = map[r][c];
                    L = 1;
                }
 
                if (L >= K)
                    break;
            }
            if (L < K) {
                return false;
            }
        }
        return true;
    }
 
    static void pick(int idx, int cnt, int limit, int D, int W, int K, int[][] map) {
 
        if (result != 0)
            return;
 
        if (cnt > limit)
            return;
 
        if (idx == D) {
            if (cnt != limit)
                return;
 
            if (check(D, W, K, map))
                result = limit;
        } else {
 
            // 복원을 위한 카피
            int[] arr = new int[W];
            for (int i = 0; i < W; i++) {
                arr[i] = map[idx][i];
            }
            Arrays.fill(map[idx], 0);
            pick(idx + 1, cnt + 1, limit, D, W, K, map);
            Arrays.fill(map[idx], 1);
            pick(idx + 1, cnt + 1, limit, D, W, K, map);
 
            // 복원
            for (int i = 0; i < W; i++) {
                map[idx][i] = arr[i];
            }
 
            // 해당 열 약물 안 넣는 경우
            pick(idx + 1, cnt, limit, D, W, K, map);
        }
 
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            result = 0;
 
            stk = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(stk.nextToken());
            int W = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());
 
            int[][] map = new int[D][W];
            for (int i = 0; i < D; i++) {
                stk = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
 
            if (!check(D, W, K, map)) {
                int n = 1;
                while (result == 0) {
 
                    pick(0, 0, n, D, W, K, map);
                    n++;
 
                }
            }
 
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

}