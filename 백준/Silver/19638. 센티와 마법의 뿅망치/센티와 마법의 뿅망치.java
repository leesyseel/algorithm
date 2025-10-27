import java.util.*;
import java.io.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int centi = Integer.parseInt(stk.nextToken());
		int T = Integer.parseInt(stk.nextToken());
		
		PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++){
		    Q.add(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 0;
		int maxH = Q.peek();
		while(cnt < T){
		    if(maxH < centi || maxH == 1){
		        break;
		    }
		    
		    Q.poll();
		    Q.add(maxH / 2);
		    maxH = Q.peek();
		    cnt++;
		}
		
		if(maxH < centi){
		    System.out.println("YES\n"+ cnt);
		}else{
		    System.out.println("NO\n" + maxH);
		}
	}
}
