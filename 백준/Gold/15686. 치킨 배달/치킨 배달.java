import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int result;
	
	static void pick(int snum,int check,int M,int ck, int h,int[][] home, int[][] chicken) {
		
		if(M==0) {
			int[] dist=new int[h];
			for(int i=1;i<ck;i++) {
				if((check&1<<i)!=0) {
					for(int j=0;j<h;j++) {
						int tmp=Math.abs(home[j][0]-chicken[i][0])+Math.abs(home[j][1]-chicken[i][1]);
						if(dist[j]>tmp||dist[j]==0) dist[j]=tmp;
					}
				}
			}
			
			int sum=0;
			for(int i=0;i<h;i++) {
				sum+=dist[i];
			}
			
			if(result>sum) result=sum;
			
		}else {
			for(int i=snum;i<ck;i++) {
				pick(i+1,(check|1<<i),M-1,ck,h,home,chicken);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;


		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[][] map = new int[N+2][N+2];
		int[][] home=new int[2*N][2];
		int h=0;
		int[][] chicken=new int[14][2];
		int ck=1;
		
		for(int i=1;i<=N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int n=map[i][j]=Integer.parseInt(stk.nextToken());
				if(n==1) {
					home[h][0]= i;
					home[h++][1]= j;
				}else if(n==2) {
					chicken[ck][0]= i;
					chicken[ck++][1]= j;
				}
			}
		}
		
		result=Integer.MAX_VALUE;
		pick(1,1,M,ck,h,home,chicken);
		System.out.println(result);

		
	}
}
