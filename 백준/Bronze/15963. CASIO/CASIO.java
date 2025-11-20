import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk = new StringTokenizer(br.readLine());
	    long n = Long.parseLong(stk.nextToken());
	    long m = Long.parseLong(stk.nextToken());
	    int res = 1;
	    
	    if(n != m) res = 0;
        System.out.println(res);
	}
}