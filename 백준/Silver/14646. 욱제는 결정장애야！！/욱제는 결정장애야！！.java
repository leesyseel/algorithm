import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int cnt = 0;
		int res = 0;
		while(stk.hasMoreTokens()){
		    int idx = Integer.parseInt(stk.nextToken()) - 1;
		    
		    if(check[idx]){
		        cnt--;
		    }else{
		        check[idx] = true;
		        cnt++;
		    }
		    
		    res = Math.max(res, cnt);
		}
        System.out.println(res);
	}
}
