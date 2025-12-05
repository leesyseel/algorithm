import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb;
    static int cnt;
    
    static void solve(int n, int from, int to, int tmp){
        cnt++;
        if(n == 1){
            sb.append(from + " "+ to + "\n");
            return;
        } 
        
        solve(n - 1, from, tmp, to);
        sb.append(from + " "+ to + "\n");
        solve(n - 1, tmp, to, from);
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		cnt = 0;
		solve(N, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb);
	}
}
