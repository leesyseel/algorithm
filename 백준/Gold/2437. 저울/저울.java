import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
		    arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = 0; i < N; i++){
		    if(arr[i] >= sum + 2) break;
		    sum += arr[i];
		}
		System.out.println(sum + 1);
	}
}
