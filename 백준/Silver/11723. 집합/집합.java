import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(stk.nextToken());
		Set<Integer> S = new HashSet<>();
		String act;
		
		
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			act=stk.nextToken();
			
			if(!stk.hasMoreTokens()) {
				switch(act) {
				case "all":
					for(int j=1;j<21;j++)
						if(!S.contains(j)) S.add(j);
					break;
				case "empty":
					for(int j=1;j<21;j++)
						S.removeAll(S);
					break;
				}
			}else {
				int idx=Integer.parseInt(stk.nextToken());
				switch (act) {
				case "add":
					if(!S.contains(idx)) S.add(idx);
					break;
				case "remove":
					if(S.contains(idx)) S.remove(idx);
					break;
				case "check":
					int res=0;
					if(S.contains(idx)) res=1;
					sb.append(res+"\n");
					break;
				case "toggle":
					if(S.contains(idx)) S.remove(idx);
					else S.add(idx);
					break;
				}
			}
			
		}
		System.out.println(sb);

	}
}
