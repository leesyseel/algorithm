import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    int T = Integer.parseInt(br.readLine());
	    
	    while(T-- > 0){
	        int N = Integer.parseInt(br.readLine());
	        int sum = 0;
	        StringTokenizer stk = new StringTokenizer(br.readLine());
	        for(int i = 0; i < N; i++){
	            sum += Integer.parseInt(stk.nextToken());
	        }
	        sb.append(sum + "\n");
	    }
        System.out.println(sb);
	}
}
