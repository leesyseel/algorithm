import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N =Integer.parseInt(bf.readLine());
		bf.close();
		
		int result=0;
		
		if(N!=0) {
			int two=0, five=0;
			for(int i=1;i<=N;i++) {
				int num=i;
				while(num%2==0) {
					two++;
					num=num/2;
				}
				num=i;
				while(num%5==0) {
					five++;
					num=num/5;
				}
			}
			result=Math.min(two, five);
		}
		
		bw.append(Integer.toString(result)).append("\n");
		bw.flush();
		bw.close();
	
	}
}