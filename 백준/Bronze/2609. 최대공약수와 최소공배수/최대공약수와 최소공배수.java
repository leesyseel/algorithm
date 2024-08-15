import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inp = bf.readLine().split(" ");
		int a=Integer.parseInt(inp[0]);
		int b=Integer.parseInt(inp[1]);
		int tmp=1;
		
		if(a<b) {
			int t=a;
			a=b;
			b=t;
		}
		
		if(a%b==0) {
			tmp=b;
			a=a/b; b=1;
		}else {
			int N=b;
			for(int i=2;i<=N/2;i++) {
				while(true) {
					if(a%i==0&&b%i==0) {
						a=a/i; b=b/i;
						tmp=tmp*i;
					}else {break;}
				}
			}
		}

		bw.append(tmp+"").append("\n");
		bw.append((tmp*a*b)+"").append("\n");
		
		bw.flush();
		bw.close();
		bf.close();
	}
}
