import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result, cnt=0;
	
	static void zet(int length,int y, int x,int r, int c) {
		if(result!=0) return;
		
		if(length==1) {
			cnt++;
			if(y==r&&x==c) result=cnt;
			return;
		}
		
		if(y+length-1<r||x+length-1<c) {
			cnt+=length*length;
			return;
		}
		
		
		int L=length/2;
		zet(L,y,x,r,c);
		zet(L,y,x+L,r,c);
		zet(L,y+L,x,r,c);
		zet(L,y+L,x+L,r,c);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		
		result=0;
		cnt=-1;
		zet(1<<N,0,0,r,c);
		
		System.out.println(result);
	}

}
