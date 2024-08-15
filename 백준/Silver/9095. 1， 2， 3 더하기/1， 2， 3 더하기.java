import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int result;
	public static void sum_cnt(int s, int n) {
		if (s==n) {
			result++;
		}else if(s>n) {
			return;
		}else {
			sum_cnt(s+1,n);
			sum_cnt(s+2,n);
			sum_cnt(s+3,n);
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb= new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			result=0;
			sum_cnt(0,n);
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}

}
