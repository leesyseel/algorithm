import java.util.*;
import java.io.*;

class Main{
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        
        int[] coin = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        int cnt = 0;
        for(int i = N - 1; i >= 0; i--){
            cnt += K / coin[i];
            K %= coin[i];
            if(K == 0) break;
        }
        System.out.println(cnt);
	}
}
