import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = (" " + br.readLine()).toCharArray();
		char[] orange = " orange".toCharArray();
		int[][] dp = new int[orange.length][str.length];
		
		for(int i = 1; i < orange.length; i++){
		    
		    char alpha = orange[i];
		    
		    for(int j = 1; j < str.length; j++){
		        if(str[j] == alpha && (i == 1 || dp[i - 1][j] != 0)){
		            dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + 1;
		        }else{
		            dp[i][j] = dp[i][j - 1];
		        }
		    }
		}
		
		int len = dp[orange.length - 1][str.length - 1];
		System.out.println(len);
		if(len == 0) return;
		
		StringBuilder sb = new StringBuilder();
		int x = orange.length - 1;
		int y = str.length - 1;
		
		while(len > 0){
		    if(dp[x][y] == len){
		        sb.append(orange[x]);
		        
		        while(dp[x][y] == len){
		            y--;
		        }
		        len--;
		    }else{
		        x--;
		    }
		}
		System.out.println(sb.reverse());
	}
}
