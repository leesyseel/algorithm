import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuffer sb;
	static int[] check;
	static int N,M;
	
	static void perm(int idx, int[] arr) {
		if(idx==M) {
			for(int j=0;j<M;j++) {
				sb.append(arr[j]+" ");
			}
			sb.append("\n");
		}else {
			for(int i=1;i<N+1;i++) {
				if(check[i]==0) {
					check[i]=1;
					arr[idx]=i;
					perm(idx+1,arr);
					check[i]=0;
				}
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
		check=new int[N+1];
		int[] arr=new int[M];
		
		perm(0,arr);

		System.out.println(sb);
	}

}