import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk=new StringTokenizer(br.readLine());
		int N= Integer.parseInt(stk.nextToken());
		int L= Integer.parseInt(stk.nextToken());
		
		int[] fruit = new int[N];
		stk=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			fruit[i]=Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(fruit);
		
		for(int i=0;i<N;i++) {
			if(fruit[i]<=L) {
				L++;
			}else {
				break;
			}
		}
		
		System.out.println(L);
	}

}
