import java.io.*;
import java.util.*;

public class Main{
    static int res, N, limit;
    static int[] map;
    static boolean[] check;
    
    static void solve(int flower, int idx, int cost){
        
        if(cost > res) return;
        
        if(flower == 3){
            res = res < cost ? res : cost;
            return;
        }
        
        for(int i = idx; i <= limit; i++){
            if(i % N == 0 || (i + 1) % N ==0 || check[i] || check[i - N] || check[i - 1] || check[i + 1] || check[i + N]) continue;
            
            int sum = map[i] + map[i - N] + map[i - 1] + map[i + 1] + map[i + N];  
            check[i] = check[i - N] = check[i - 1] = check[i + 1] = check[i + N] = true;
            solve(flower + 1, i + 1, cost + sum);
            check[i] = check[i - N] = check[i - 1] = check[i + 1] = check[i + N] = false;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N * N];
        check = new boolean[N * N];
        limit = (N - 2) * N + (N - 2);
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i * N + j] = Integer.parseInt(stk.nextToken());
            }
        }
        
        res = Integer.MAX_VALUE;
        solve(0, N + 1, 0);
        System.out.println(res);
    }
}