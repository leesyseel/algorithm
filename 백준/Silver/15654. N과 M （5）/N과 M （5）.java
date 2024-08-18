import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N,M;
	
	static void perm(int nidx, int midx, int check,int[] nums,int[] arr) {
		if(midx==M) {
			for(int j=0;j<M;j++) {
				sb.append(arr[j]+" ");
			}
			sb.append("\n");
		}else {
			for(int i=1;i<=N;i++) {
				if((check&1<<i)==0) {
					arr[midx]=nums[i];
					perm(i+1,midx+1,check|1<<i,nums,arr);
				}
				
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		sb = new StringBuilder();

		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		int[] nums=new int[N+1];
		for(int i=1;i<=N;i++) {
			nums[i]=Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(nums);
		int[] arr=new int[M];
		perm(1,0,1,nums,arr);

		System.out.println(sb);
	}

}