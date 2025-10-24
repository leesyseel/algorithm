import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int num = 1; num <= N; num++){
		    int t = Integer.parseInt(stk.nextToken());
		    
		    for(int i = 0; i < N; i++){
		        if(arr[i] != 0) continue;
		        
		        if(t == 0){
		            arr[i] = num;
		            break;
		        }
		        t--;
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++){
		    sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
	}
}
