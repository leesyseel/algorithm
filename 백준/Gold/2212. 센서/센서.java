import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int K = Integer.parseInt(br.readLine());
	    if(N <= K){
	        System.out.println(0);
	        return;
	    }
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        
        Integer[] gap = new Integer[N - 1];
        for(int i = 0; i < N - 1; i++){
            gap[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(gap, Collections.reverseOrder());
        
        int sum = 0;
        for(int i = K - 1; i < N - 1; i++){
            sum += gap[i];
        }
        System.out.println(sum);
	}
}
