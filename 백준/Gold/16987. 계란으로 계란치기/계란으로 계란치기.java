import java.util.*;
import java.io.*;

public class Main{
    static int N, res;
    static int[] power, weight;
    
    public static void solve(int idx, int cnt){
        
        if(idx == N){
            if(cnt > res) res = cnt;
            return;
        }
        
        if(power[idx] <= 0){
            solve(idx + 1, cnt);
            return;
        }
        
        boolean flag = true;
        for(int i = 0; i < N; i++){
            if(i == idx || power[i] <= 0) continue;
            
            flag = false;
            power[i] -= weight[idx];
            power[idx] -= weight[i];
            
            int tmp = 0;
            if(power[i] <= 0) tmp++;
            if(power[idx] <= 0) tmp++;
            
            solve(idx + 1, cnt + tmp);
            
            power[i] += weight[idx];
            power[idx] += weight[i];
        }
        if(flag) solve(idx + 1, cnt);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        power = new int[N];
        weight = new int[N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            power[i] = Integer.parseInt(stk.nextToken());
            weight[i] = Integer.parseInt(stk.nextToken());
        }
        
        res = 0;
        solve(0, 0);
        System.out.println(res);
        
    }
}