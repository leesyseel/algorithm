import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static int[] odd = {1,3,5,7,9};

	static void special(int num, int length, int N) {

		if(length==N) {
			sb.append(num+"\n");
		}else {
			for(int i=0;i<5;i++) {
				int tmp=num*10+odd[i];
				if(isPrime(tmp)) {
					special(tmp,length+1,N);
				}
			}
		}
	}
	
	static boolean isPrime(int num) {
		
		int rt=(int) Math.sqrt(num);
		for(int i=2;i<=rt;i++)
			if(num%i==0) return false;
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb= new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] first = {2,3,5,7};
		
		
		for(int i=0;i<4;i++) {
			special(first[i],1,N);
		}


		System.out.println(sb);
	}
}