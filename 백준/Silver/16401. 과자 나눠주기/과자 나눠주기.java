import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		
		int left = 1, right = 0;
		int[] cookies = new int[N];
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
		    cookies[i] = Integer.parseInt(stk.nextToken());
		    right = Math.max(cookies[i], right);
		}
		
		int res = 0;
		while(left <= right){
		    int mid = (left + right) / 2;
		    int cnt = 0;
		    
		    for(int i = 0; i < N; i++){
		        cnt += cookies[i] / mid;
		    }
		    
		    if(cnt >= M){
		        res = Math.max(res, mid);
		        left = mid + 1;
		    }else{
		        right = mid - 1;
		    }
		}
		System.out.println(res);
	}
}
