import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		int cnt=0;
		int i=0;
		while((1<<i)<=X) {
			if((X&1<<i)!=0) cnt++;
			i++;
		}
		System.out.println(cnt);
		
	}
}