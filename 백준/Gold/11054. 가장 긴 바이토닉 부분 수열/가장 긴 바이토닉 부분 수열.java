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
	    
	    int[] up = new int[N];
	    int[] down = new int[N];
	    Arrays.fill(up, 1);
	    Arrays.fill(down, 1);
	    
	    for(int curl = 1; curl < N; curl++){
	        for(int i = 0; i < curl; i++){
	            if(arr[curl] > arr[i] && up[i] + 1 > up[curl]){
	                up[curl]++;
	            }
	        }
	    }
	    
	    for(int curl = N - 2; curl >= 0; curl--){
	        for(int i = N - 1; i > curl; i--){
	            if(arr[curl] > arr[i] && down[i] + 1 > down[curl]){
	                down[curl]++;
	            }
	        }
	    }
	    
	    int max = 0;
	    for(int i = 0; i < N; i++){
	        max = Math.max(max, up[i] + down[i]);
	    }
	    System.out.println(max - 1);
	}
}
