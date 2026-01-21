import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		char[] arr = br.readLine().toCharArray();
		
		int res = 0;
		for(int i = 0; i < N; i++){
		    if(arr[i] != 'P') continue;
		    
		    int start = Math.max(0, i - K);
		    int end = Math.min(N - 1, i + K);
		    
		    for(int j = start; j <= end; j++){
		        if(arr[j] == 'H'){
		            arr[j] = ' ';
		            res++;
		            break;
		        }
		    }
		}
		System.out.println(res);
	}
}
