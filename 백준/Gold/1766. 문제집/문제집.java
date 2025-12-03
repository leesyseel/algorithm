import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[] before = new int[N + 1];
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++){
	        arr[i] = new ArrayList<>();
	    }
		
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(stk.nextToken());
		    int b = Integer.parseInt(stk.nextToken());
		    
		    arr[a].add(b);
		    before[b]++;
		}
		
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		for(int i = 1; i <= N; i++){
		    if(before[i] == 0) Q.add(i);
		}
		
		while(!Q.isEmpty()){
		    int curl = Q.poll();
		    sb.append(curl + " ");
		    
		    for(int nxt : arr[curl]){
		        if(--before[nxt] == 0) Q.add(nxt);
		    }
		}
		System.out.println(sb);
	}
}
