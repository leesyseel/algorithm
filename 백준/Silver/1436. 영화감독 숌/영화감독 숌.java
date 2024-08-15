import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int cnt=0;
		int now=666;
		String s="";
		while(cnt!=N) {
			s = Integer.toString(now);
			for(int j=0;j<s.length()-2;j++) {
				if (s.charAt(j)-'0'==6&&s.charAt(j+1)-'0'==6&&s.charAt(j+2)-'0'==6) {
					cnt+=1;
					break;
				}
			}
			now++;
		}
		System.out.println(s);
		
	
	}

}
