import java.io.*;
import java.util.*;

public class Main {

	static long div_cq(int a, int b, int c) {
		
		if(b==1) return a%c;
		
		long tmp=(div_cq(a, b / 2, c));
		
		if(b%2==0) {
			return tmp*tmp%c;
		}else {
			return (tmp*tmp)%c*a%c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		
		long res= div_cq(A, B , C);

		System.out.println(res);

	}
}
