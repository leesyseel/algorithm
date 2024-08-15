import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,result;
	static char[][] board;
	static char[][] std= {{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		result=Integer.MAX_VALUE;

		M = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		
		board = new char[M][N];
		String[] s;
		for(int i=0;i<M;i++) {
			s=br.readLine().split("");
			for(int j=0;j<N;j++) {
				board[i][j]=s[j].charAt(0);
			}
		}

		for (int i = 0; i < M - 7; i++) {
			for (int j = 0; j < N - 7; j++) {
				cntColor(i, j);
			}
		}
		System.out.println(result);

	}

	public static void cntColor(int r, int c) {
		
		int W=0,B=0;
		
		for(int i=r;i<r+8;i++){
			for(int j=c;j<c+8;j++) {
				if (board[i][j]!=std[i%2][j-c]) W++;
				
				if (board[i][j]!=std[(i+1)%2][j-c]) B++;
			}
		}
		
		int tmp = W < B ? W : B ;
		result = tmp < result ? tmp : result;
	}

}