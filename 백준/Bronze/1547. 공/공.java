import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int cup = 1;
	    
	    for(int i = 0; i < N; i++){
	        StringTokenizer stk = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(stk.nextToken());
	        int b = Integer.parseInt(stk.nextToken());
	        
	        if(a == cup){
	            cup = b;
	        }else if(b == cup){
	            cup = a;
	        }
	    }
        System.out.println(cup);
	}
}