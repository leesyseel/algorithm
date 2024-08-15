import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		String[] in_shirt = bf.readLine().split(" ");
		String[] inp = bf.readLine().split(" ");
		int T=Integer.parseInt(inp[0]);
		int P=Integer.parseInt(inp[1]);
		int shirt=0;
		
		for(String s:in_shirt) {
			int num=Integer.parseInt(s);
			if(num%T==0) shirt+=num/T;
			else shirt+=num/T+1;
		}
		bw.append(Integer.toString(shirt)).append("\n");
		
		bw.append(Integer.toString(N/P)).append(" ");
		bw.append(Integer.toString(N%P)).append("\n");
			
		bw.flush();
		bw.close();
		bf.close();
	}
}
