import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inp=bf.readLine().split(" ");
		int N=Integer.parseInt(inp[0]);
		int K=Integer.parseInt(inp[1]);
		
		if(N-K<K) K=N-K;
		
		int up=1, down=1;
		for(int n=N;n>N-K;n--) {
			up*=n;
		}
		for(int k=1;k<=K;k++) {
			down*=k;
		}
		
		bw.append(Integer.toString(up/down)).append("\n");
		
		bw.flush();
		bw.close();
		bf.close();
	}
}
