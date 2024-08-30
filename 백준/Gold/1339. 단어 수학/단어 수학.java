import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		int[] alpha = new int[26];

		for(int i=0;i<N;i++) {
			String s=br.readLine();
			int len = s.length();
			
			for(int j=0;j<len;j++) {
				int spell=s.charAt(j)-65;
				alpha[spell]+=(int) Math.pow(10, len-j-1);
			}
		}
		
		int res=0;
		int num=9;
		Arrays.sort(alpha);
		for(int i=25;i>=0;i--) {
			if(alpha[i]==0) break;
			res+=alpha[i]*(num--);
		}
		
		System.out.println(res);

	}

}
