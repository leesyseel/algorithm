import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        long M = Long.parseLong(stk.nextToken());
        
        long[] nums = new long[N];
        for(int i = 0; i < N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(nums);
        long res = Long.MAX_VALUE;
        
        int lt = 0; int rt = 0;
        while(rt < N){
            long gap = nums[rt] - nums[lt];
            if(gap < M) {
                rt++;
            }else{
                if(res > gap) res = gap;
                lt++;
                if(lt > rt) rt = lt; 
            }
        }
        System.out.println(res);
    }
}