import java.util.*;
import java.io.*;

class Main{
    
    static class Balloon{
        int idx, val;
        
        public Balloon(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Balloon> Q = new ArrayDeque<>();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
		    Q.add(new Balloon(i, Integer.parseInt(stk.nextToken())));
		}
		
		while(!Q.isEmpty()){
		    Balloon curl = Q.pollFirst();
		    int idx = curl.idx;
		    int val = curl.val;
		    sb.append(idx+ " ");
		    
		    if(Q.size() == 0) break;
		    
		    if(val > 0){
		        for(int i = 0; i < val - 1; i++){
		            Balloon tmp = Q.pollFirst();
		            Q.add(tmp);
		        }
		        
		    }else{
		        for(int i = 0; i > val; i--){
		            Balloon tmp = Q.pollLast();
		            Q.addFirst(tmp);
		        }
		    }
		}
		
        System.out.println(sb);
	}
}
