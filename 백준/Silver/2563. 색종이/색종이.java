import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		boolean[][] check =new boolean[101][101];
		
		int N = Integer.parseInt(br.readLine());
		int result=0;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			
			for(int k=r;k<r+10;k++) {
				for(int j=c;j<c+10;j++) {
					if(check[k][j]) continue;
					
					check[k][j]=true;
					result++;
				}
			}
		}
		System.out.println(result);	
	}
}
