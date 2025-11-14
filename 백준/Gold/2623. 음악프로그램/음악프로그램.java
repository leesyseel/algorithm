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
	        arr[i] = new ArrayList<Integer>();
	    }
	    
	    for(int i = 0; i < M; i++){
	        stk = new StringTokenizer(br.readLine());
	        int len = Integer.parseInt(stk.nextToken());
	        
	        int b = Integer.parseInt(stk.nextToken());
	        for(int j = 0; j < len - 1; j++){
	            int a = Integer.parseInt(stk.nextToken());
	            arr[b].add(a);
	            before[a]++;
	            b = a;
	        }
	    }
	    
	    int cnt = 0;
	    Queue<Integer> Q = new ArrayDeque<Integer>();
	    for(int i = 1; i <= N; i++){
	        if(before[i] == 0){
	            Q.add(i);
	        }
	    }
	    
	    while(!Q.isEmpty()){
	        int curl = Q.poll();
	        sb.append(curl+"\n");
	        cnt++;
	        
	        for(int nxt : arr[curl]){
	            if(--before[nxt] == 0){
	                Q.add(nxt);
	            }
	        }
	    }
	    
	    if(cnt != N){
	        System.out.println(0);
	        return;
	    }
	    System.out.println(sb);
	}
}
