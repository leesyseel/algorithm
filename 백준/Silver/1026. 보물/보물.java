import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    Integer[] a = new Integer[N];
	    stk = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++){
	        a[i] = Integer.parseInt(stk.nextToken());
	    }
	    Arrays.sort(a, Collections.reverseOrder());
	    
	    int[] b = new int[N];
	    stk = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++){
	        b[i] = Integer.parseInt(stk.nextToken());
	    }
	    Arrays.sort(b);
	    
	    int sum = 0;
	    for(int i = 0; i< N; i++){
	        sum += a[i] * b[i];
	    }
	    
	    System.out.println(sum);
	}
}
