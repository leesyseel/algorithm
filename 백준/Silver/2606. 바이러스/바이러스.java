import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int L= Integer.parseInt(br.readLine());
		
		int[][] computers=new int[n+1][n+1];
		for(int i=0;i<L;i++) {
			String[] str=br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			computers[a][b]=1;
			computers[b][a]=1;
		}
		
		int[] queue=new int[n+1];
		int[] check=new int[n+1];
		int rear=0, top=0;
		queue[top++]=1;
		check[1]=1;
		
		
		while(rear!=top) {
			int a=queue[rear++];
			for(int i=1;i<n+1;i++) {
				if (computers[a][i]==1&&check[i]==0) {
					queue[top++]=i;
					check[i]=1;
				}
			}
		}
		
		int cnt=0;
		for(int i=2;i<n+1;i++) {
			if (check[i]==1) cnt++;
		}
		System.out.println(cnt);

	}

}
