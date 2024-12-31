import java.io.*;
import java.util.*;

public class Main{
    static int N, S, res;
    static int[] nums;
    
    static void solve(int idx, int pick, int cnt){
        if(idx == N){
            if(pick == S && cnt != 0)
                res++;
            return;
        }
        solve(idx + 1, pick + nums[idx], cnt + 1);
        solve(idx + 1, pick, cnt);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());
        
        nums = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(stk.nextToken());
        }
        
        res = 0;
        solve(0, 0, 0);
        
        System.out.println(res);
    }
}