import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     
	    int N = Integer.parseInt(br.readLine());
	    int[] arr = new int[N];
	    
	    StringTokenizer stk = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++){
	        arr[i] = Integer.parseInt(stk.nextToken());
	    }
	    Arrays.sort(arr);
	    
	    int res = 0;
	    for(int i = 0; i < N; i++){
	        
	        int idx = N - 1;
	        while(idx >= 0){
	            
	            if(idx == i){
	                idx--;
	                continue;
	            }
	            
	            int remain = arr[i] - arr[idx];
	            int before = -1, after = -1;
	            before = Arrays.binarySearch(arr, 0, i, remain);
	            after = Arrays.binarySearch(arr, i + 1, N, remain);
	            
	            if((before >= 0 && before != idx && before != i) || (after >= 0 && after != idx && after!= i)){
                    res++;
	                break;
	            }
                idx--;
                
	        }
	    }
	    System.out.println(res);
	}
}
