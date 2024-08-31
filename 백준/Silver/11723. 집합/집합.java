import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		int N= Integer.parseInt(br.readLine());
		int S = 0;
		String act;
		
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			act=stk.nextToken();
			
			if(!stk.hasMoreTokens()) {
				switch(act) {
				case "all":
					S =(1<<21)-1; 					
					break;
				case "empty":
					S=0;
					break;
				}
			}else {
				int idx=Integer.parseInt(stk.nextToken());
				switch (act) {
				case "add":
					S|=1<<idx;
					break;
				case "remove":
					S &= ~(1<<idx);
					break;
				case "check":
					int res;
					if((S&1<<idx)!=0) res=1;
					else res=0;
					sb.append(res+"\n");
					break;
				case "toggle":
					if((S&1<<idx)!=0) S &= ~(1<<idx);
					else S|=1<<idx;
					break;
				}
			}
			
		}
		System.out.println(sb);

	}
}
