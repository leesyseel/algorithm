import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		long[] liquid = new long[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(stk.nextToken());
		}
		Arrays.sort(liquid);

		long acid = Long.MAX_VALUE;
		long[] pick = new long[3];
        int lt, rt;
        
        for(int i=0;i<N-2;i++){
            
            lt=i+1; rt=N-1;
            
            while(lt<rt){
                long now = liquid[i]+liquid[lt]+liquid[rt];
                
                if(Math.abs(0-now)<acid){
                    acid=Math.abs(0-now);
                    pick[0]=liquid[i];
                    pick[1]=liquid[lt];
                    pick[2]=liquid[rt];
                }
                
                if(now<0) lt++;
                else rt--;
            }
        }
 
		sb.append(pick[0]).append(" ").append(pick[1]).append(" ").append(pick[2]);
		System.out.println(sb);
	}
}