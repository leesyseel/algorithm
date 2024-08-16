import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result;
	static int A,C,G,T;

	static void pwd(int S, int P, char[] input, int a, int c, int g, int t) {
		
		A=0; C=0; G=0; T=0;
		for (int i = 0; i <= S-P; i++) {
			if(i==0) {
				for(int j=0;j<P;j++) {
					count(input[j],1);
				}
			}else {
				count(input[i-1],-1);
				count(input[i+P-1],1);
			}
			
			if(A>=a&&C>=c&&G>=g&&T>=t) result++;
		}
	}

	static void count(char c,int n) {
		switch(c) {
		case 'A':
			A+=n; break;
		case 'C':
			C+=n; break;
		case 'G':
			G+=n; break;
		case 'T':
			T+=n; break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(stk.nextToken());
		int P = Integer.parseInt(stk.nextToken());

		String str = br.readLine();
		str = str.toUpperCase();
		char[] input = new char[S];
		for (int i = 0; i < S; i++) {
			input[i] = str.charAt(i);
		}

		stk = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int g = Integer.parseInt(stk.nextToken());
		int t = Integer.parseInt(stk.nextToken());
		
		result = 0;
		pwd(S, P, input, a,c,g,t);

		System.out.println(result);
	}
}