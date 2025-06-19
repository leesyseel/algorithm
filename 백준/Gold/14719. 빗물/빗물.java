import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        
        int[] wall = new int[W];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            wall[i] = Integer.parseInt(stk.nextToken());
        }
        
        int[] left = new int[W];
        int[] right = new int[W];
        left[0] = wall[0];
        right[W - 1] = wall[W - 1];
        for(int i = 1; i < W; i++){
            left[i] = wall[i] > left[i - 1] ? wall[i] : left[i - 1];
            right[W - 1 - i] = wall[W - 1 - i] > right[W - i] ? wall[W - 1 - i] : right[W - i];
        }
        
        int res = 0;
        for(int i = 0; i < W; i++){
            int min = left[i] < right[i] ? left[i] : right[i];
            int tmp = min - wall[i] > 0 ? min - wall[i] : 0;
            res += tmp;
        }
        System.out.println(res);
    }
}