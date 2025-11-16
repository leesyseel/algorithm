import java.util.*;
import java.io.*;

class Main{
    
    static class PW{
        int num;
        int cnt;
        
        public PW(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    
	public static void main (String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    int T = Integer.parseInt(br.readLine());
	    int[] isPrime = new int[10000];
	    for(int i = 2; i < 10000; i++){
	        if(isPrime[i] != 0) continue;
	        
	        for(int j = i + i; j < 10000; j += i){
	            isPrime[j] = i;
	        }
	    }
	    
	    while(T-- > 0){
	        StringTokenizer stk = new StringTokenizer(br.readLine());
	        int from = Integer.parseInt(stk.nextToken());
	        int to = Integer.parseInt(stk.nextToken());
	        int min = Integer.MAX_VALUE;
	        boolean[] visited = new boolean[10000];
	        
	        Queue<PW> Q = new ArrayDeque<>();
	        Q.add(new PW(from, 0));
	        visited[from] = true;
	        
	        while(!Q.isEmpty()){
	            PW curl = Q.poll();
	            if(curl.num == to){
	                min = curl.cnt;
	                break;
	            }
	            
	            for(int i = 0; i < 4; i++){
	                int ten = (int) Math.pow(10, i);
	                int tmp = (curl.num / ten);
	                if(tmp >= 10) tmp %= 10;
	                int base = curl.num - tmp * ten - ten;
	                
	                for(int j = 0; j < 10; j++){
	                    base += ten;
	                    
	                    if(base < 1000 || isPrime[base] != 0 || visited[base]) continue;
	                    Q.add(new PW(base, curl.cnt + 1));
	                    visited[base] =  true;
	                }
	            }
	        }
	        
	        if(min == Integer.MAX_VALUE){
	            sb.append("Impossible\n");
	        }else{
	            sb.append(min + "\n");
	        }
	    }
        System.out.println(sb);
	}
}
