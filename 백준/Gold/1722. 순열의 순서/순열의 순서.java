import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        long[] fact = new long[N + 2];
        boolean[] check = new boolean[N + 1];
            
        fact[0] = 1;
        for(int i = 1; i < N + 2; i++){
            fact[i] = fact[i - 1] * i;
        }
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(stk.nextToken());
        
        if(t == 1){
            long k = Long.parseLong(stk.nextToken());
            
            for(int i = 0; i < N; i++){
                for(int j = 1; j <= N; j++){
                    if(check[j]) continue;
                    
                    if(k - fact[N - 1 - i] > 0){
                        k -= fact[N - 1 - i];
                    }else{
                        check[j] = true;
                        sb.append(j+" ");
                        break;
                    }
                }
            }
            
        }else{
            int[] nums = new int[N];
            for(int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(stk.nextToken());
            }
            
            long res = 1;
            for(int i = 0; i < N; i++){
                for(int j = 1; j < nums[i]; j++){
                    if(check[j]) continue;
                    
                    res += fact[N - 1 - i];
                }
                check[nums[i]] = true;
            }
            sb.append(res);
        }
        System.out.println(sb);
    }
}