import java.util.*;
import java.io.*;

class Main{
    
    
    static int N;
    static int res;
    static HashSet<Integer> set;
    
    static void solve(int num, int cnt){
        
        for(int pick : set){
            res = Math.min(res, cnt + 1 + Math.abs(num * 10 + pick - N));
            
            if(cnt <= 6){
                solve(num * 10 + pick, cnt + 1);
            }
        }
    }
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    int M = Integer.parseInt(br.readLine());
	    set = new HashSet<>();
	    for(int i = 0; i < 10; i++){
	        set.add(i);
	    }
	    
	    if(M > 0){
	        StringTokenizer stk = new StringTokenizer(br.readLine());
	        for(int i = 0; i < M; i++){
	            set.remove(Integer.parseInt(stk.nextToken()));
	        }
	    }
	    
	    res = Math.abs(N - 100);
	    if(!set.isEmpty()){
	        solve(0, 0);
	    }
	    
	    System.out.println(res);
	}
}
