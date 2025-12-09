import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stk;
	    
	    int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        
        stk = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        long S = Long.parseLong(stk.nextToken());
        
        int lt = 1;
        int rt = 100000 + q;
        int K = -1;
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            
            long sum = 0L;
            for(int i = 0; i < N; i++){
                int tmp = arr[i];
                if(tmp < mid) tmp += q;
                else if(tmp > mid + r) tmp -= p;
                sum += tmp;
            }
            
            if(sum < S){
                lt = mid + 1;
            }else{
                rt = mid - 1;
                K = mid;
            }
        }
	    System.out.println(K);
	}
}
