import java.util.*;
import java.io.*;

class Main{
    static StringBuilder sb;
    static boolean[] check;
    static char[] arr;
    static int len;
    
	public static void main (String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    sb = new StringBuilder();
	    arr = br.readLine().toCharArray();
	    len = arr.length;
	    check = new boolean[len];
	    
	    solve(0, len - 1);
	    
	    System.out.println(sb);
	}
	
	static void solve(int left, int right){
	    if(left > right) return;
	    
	    int idx = left;
	    for(int i = left + 1; i <= right; i++){
	        if(arr[idx] <= arr[i]) continue;
	        idx = i;
	    }
	    check[idx] = true;
	    
	    for(int i = 0; i < len; i++){
	        if(!check[i]) continue;
	        sb.append(arr[i]);
	    }
	    sb.append("\n");
	    
	    solve(idx + 1, right);
	    solve(left, idx - 1);
	}
}
