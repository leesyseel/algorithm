import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    stk = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(stk.nextToken());
	    long S = Long.parseLong(stk.nextToken());
	    
	    long[] arr = new long[N];
	    stk = new StringTokenizer(br.readLine());
	    arr[0] = Long.parseLong(stk.nextToken());
	    
	    for(int i = 1; i < N; i++){
	        arr[i] = arr[i - 1] + Long.parseLong(stk.nextToken());
	    }
	    
	    int left = -1;
	    int right = 0;
	    long min = Long.MAX_VALUE;
	    
	    while(left <= right && right < N){
	        long L = left < 0L ? 0L : arr[left];
	        long R = arr[right];
	        
	        if(R - L < S){
	            right++;
	        }else{
	            min = Math.min(min, right - left);
	            left++;
	        }
	    }
	    
	    if(min == Long.MAX_VALUE) min = 0;
	    System.out.println(min);
	}
}