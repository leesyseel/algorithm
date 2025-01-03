import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer stk;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc = 1; tc <= T; tc++) {
    		
    		stk = new StringTokenizer(br.readLine());
    		int N = Integer.parseInt(stk.nextToken());
    		long M = Long.parseLong(stk.nextToken());
    		
    		long[] nums = new long[N];
    		stk = new StringTokenizer(br.readLine());
    		for(int i = 0; i < N; i++) {
    			nums[i] = Long.parseLong(stk.nextToken());
    		}
    		
    		long res = 0;
    		
    		long lt = 0;
    		long rt = Long.MAX_VALUE;
    		
    		while(lt <= rt) {
    			long mid = (lt + rt) / 2;
    			if(mid == 0) break;
    			
    			long sum = 0;
    			for(long cnt : nums) {
    				sum += cnt / mid;
    			}
    			
    			if(sum >= M) {
    				res = mid;
    				lt = mid + 1;    				
    			}else {
    				rt = mid - 1;
    			}
    		}    		
    		sb.append("#").append(tc).append(" ").append(res).append("\n");
    	}
    	System.out.println(sb);
    }
}
