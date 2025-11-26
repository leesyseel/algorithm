import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int res = 0;
	    
	    int N = Integer.parseInt(br.readLine());
	    for(int i = 0; i < N; i++){
	        boolean[] check = new boolean[26];
	        char[] arr = br.readLine().toCharArray();
	        
	        if(arr.length == 1){
	            res++;
	            continue;
	        }
	        
	        char before = arr[0];
	        check[arr[0] - 'a'] = true;
	        boolean flag = false;
	        for(int j = 1; j < arr.length; j++){
	            if(arr[j] == before) continue;
	            
	            if(check[arr[j] - 'a']){
	                flag = true;
	                break;
	            }
	            
	            before = arr[j];
	            check[arr[j] - 'a'] = true;
	        }
	        
	        if(!flag) res++;
	    }
	    System.out.println(res);
	    
	}
}