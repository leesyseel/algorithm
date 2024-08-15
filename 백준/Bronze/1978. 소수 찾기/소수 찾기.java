import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		String[] inp = bf.readLine().split(" ");
		int result=0;
		for(int i=0; i<N;i++) {
			int num=Integer.parseInt(inp[i]);
			if (num==1||num==0) {continue;}
			int[] check=new int[num+1];
			for(int j=2;j<num;j++) {
				if(check[j]==0) {
					for(int k=j;k<num+1;k+=j)
						check[k]=1;
				}
			}
			if (check[num]==0) result+=1;
		}
			
		bw.append(Integer.toString(result)).append("\n");
		bw.flush();
		bw.close();
		bf.close();
	}
}
