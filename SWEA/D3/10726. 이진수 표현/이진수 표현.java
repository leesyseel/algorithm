import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String args[]) throws IOException{
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer stk;
    	
    	int T =Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            //입력
        	sb.append("#").append(tc).append(" ");
        	
        	stk=new StringTokenizer(br.readLine());
        	int N =Integer.parseInt(stk.nextToken());
        	int M =Integer.parseInt(stk.nextToken());
            
        	boolean flag=true;
        	for(int i=0;i<N;i++) {
        		if((M&1<<i)==0) {
        			flag=false;
        			break;
        		}
        	}
        	
        	if(flag) sb.append("ON").append("\n");
        	else sb.append("OFF").append("\n");
        }
        System.out.println(sb);
    }
}