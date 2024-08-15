import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuffer sb;
	static int N,M;
	
	static void perm(int idx, int snum, int[] arr) {
		if(idx==M) {
			for(int j=0;j<M;j++) {
				sb.append(arr[j]+" ");
			}
			sb.append("\n");
		}else {
			for(int i=snum;i<N+1;i++) {
				arr[idx]=i;
				perm(idx+1,i+1,arr);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		sb = new StringBuffer();

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		int[] arr=new int[M];
		
		perm(0,1,arr);

		System.out.println(sb);
	}

}