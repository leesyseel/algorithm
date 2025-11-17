import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    stk = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(stk.nextToken());
	    int M = Integer.parseInt(stk.nextToken());
	    int L = Integer.parseInt(stk.nextToken());
        
        int[] arr = new int[N + 2];
        arr[N + 1] = L; 
        if(N > 0){
            stk = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            Arrays.sort(arr);
        }
        
        int left = 1; int right = L - 1;
        int res = 0;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            
            for(int i = 1; i <= N + 1; i++){
                int tmp = arr[i] - arr[i - 1];
                cnt += tmp / mid;
                
                if(tmp % mid == 0) cnt -= 1;
            }
            
            if(cnt > M){
                left = mid + 1;
            }else{
                right = mid - 1;
                res = mid;
            }
        }
        System.out.println(res);
	}
}