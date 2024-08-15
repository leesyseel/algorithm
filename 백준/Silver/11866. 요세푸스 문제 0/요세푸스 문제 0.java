import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append("<");
		
		String[] inp=br.readLine().split(" ");
		int N=Integer.parseInt(inp[0]);
		int K=Integer.parseInt(inp[1]);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) Q.add(i);
		int cnt=0, tmp=0;
		while(!Q.isEmpty()) {
			cnt++;
			tmp=Q.poll();
			if(cnt==K) {
				bw.append(tmp+"");
				cnt=0;
				if(!Q.isEmpty()) bw.append(", ");
			}else {
				Q.add(tmp);
			}
		}
		bw.append(">\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
