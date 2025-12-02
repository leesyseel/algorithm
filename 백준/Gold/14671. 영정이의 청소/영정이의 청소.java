import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		boolean[][] check = new boolean[2][2];
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		
		while(K-- > 0){
		    stk = new StringTokenizer(br.readLine());
		    int i = Integer.parseInt(stk.nextToken());
		    int j = Integer.parseInt(stk.nextToken());
		    check[i % 2][j % 2] = true;
		}
		
		String res = "NO";
		if(check[0][0] && check[0][1] && check[1][0] && check[1][1]) res = "YES";
		System.out.println(res);
	}
}
