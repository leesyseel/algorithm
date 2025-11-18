import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    int T = Integer.parseInt(br.readLine());
	    
	    while(T-- > 0){
	        StringTokenizer stk = new StringTokenizer(br.readLine());
	        double num = Double.parseDouble(stk.nextToken());
	        
	        while(stk.hasMoreTokens()){
	            switch(stk.nextToken()){
	                case "@":
	                    num *= 3;
	                    break;
	                case "%":
	                    num += 5;
	                    break;
	                case "#":
	                    num -= 7;
	                    break;
	            }
	        }
	        sb.append(String.format("%.2f\n", num));
	    }
        System.out.println(sb);
	}
}