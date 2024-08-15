import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int num=Integer.parseInt(bf.readLine());
			if(num==0) break;
			
			int rev=0, org=num;
			while(num>0) {
				rev=rev*10+num%10;
				num=num/10;
			}
			String result="";
			if (rev==org) result="yes";
			else result="no";
			
			bw.append(result).append("\n");
			bw.flush();
		}
		bw.close();
		bf.close();
	}
}
