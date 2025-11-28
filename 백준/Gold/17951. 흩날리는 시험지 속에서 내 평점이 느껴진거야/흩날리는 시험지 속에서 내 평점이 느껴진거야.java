import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    stk = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(stk.nextToken());
	    int K = Integer.parseInt(stk.nextToken());
	    int[] arr = new int[N];
	    
	    int res = 0;
	    int left = 0, right = 0;
	    
	    stk = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++){
	        arr[i] = Integer.parseInt(stk.nextToken());
	        right += arr[i];
	    }
	    
	    while(left <= right){
	        int mid = (left + right) / 2;
	        
	        int groupCnt = 0;
	        int tmp = 0;
	        for(int i = 0; i < N; i++){
	            tmp += arr[i];
	            if(mid <= tmp){
	                groupCnt++;
	                tmp = 0;
	            }
	        }
	        
	        if(groupCnt >= K){
	            left = mid + 1;
	        }else{
	            right = mid - 1;
	        }
	    }
	    System.out.println(right);
	}
}
