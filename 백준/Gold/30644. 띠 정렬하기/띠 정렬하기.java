import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
		    arr[i] = Integer.parseInt(stk.nextToken());
		    map.put(arr[i], i);
		}
		Arrays.sort(arr);
		
		for(int i = 0; i < N - 1; i++){
		    int a = map.get(arr[i]);
		    int b = map.get(arr[i + 1]);
		    
		    if(Math.abs(a - b) != 1) res++;
		}
		
        System.out.println(res);
	}
}
