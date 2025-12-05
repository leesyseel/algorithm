import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr1 = br.readLine().toCharArray();
		int len1 = arr1.length;
		char[] arr2 = br.readLine().toCharArray();
		int len2 = arr2.length;
		
		int[][] dp = new int[len1][len2];
	    if(arr1[0] == arr2[0]) dp[0][0] = 1;
	    
	    for(int i = 1; i < len1; i++){
	        int tmp = 0;
	        if(arr2[0] == arr1[i]) tmp++;
	        dp[i][0] = Math.max(dp[i - 1][0], tmp);
	    }
	    for(int i = 1; i < len2; i++){
	        int tmp = 0;
	        if(arr1[0] == arr2[i]) tmp++;
	        dp[0][i] = Math.max(dp[0][i -1], tmp);
	    }
		
		for(int i = 1; i < len1; i++){
		    for(int j = 1; j < len2; j++){
		        if(arr1[i] == arr2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
		        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		    }
		}
		
		int max = dp[len1 -1][len2 - 1];
		System.out.println(max);
 		if(max == 0) return;
		
		StringBuilder sb = new StringBuilder();
		int r = len1 - 1; int c = len2 - 1;
		while(max > 0){
		    if(arr1[r] == arr2[c]){
		        sb.append(arr1[r]);
		        r--; c--; max--;
		        continue;
		    }
		    if( r >= 1 && dp[r - 1][c] == dp[r][c]){
		        r--;
		    }else if(c >= 1 && dp[r][c - 1] == dp[r][c]){
		        c--;      
		    }
		}
		System.out.println(sb.reverse());
	}
}
