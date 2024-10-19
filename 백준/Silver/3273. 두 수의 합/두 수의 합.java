import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int N=Integer.parseInt(br.readLine());
		
		int[] list=new int[N];
		stk=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list[i]=Integer.parseInt(stk.nextToken());
		}
		
		int X=Integer.parseInt(br.readLine());
		
		Arrays.sort(list);
		int lt=0; int rt=N-1;
		int result=0; int sum=0;
		
		while(lt<rt) {
			sum=list[lt]+list[rt];
			if(sum==X) {
				lt++;rt--;
				result++;
			}else if(sum>X) {
				rt--;
			}else {
				lt++;
			}
		}
		System.out.println(result);
	}
}