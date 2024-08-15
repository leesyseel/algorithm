import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		if(N==1) {sb.append(1);}
		else if(N==2||N==3) {sb.append(2);}
		else {
			//int[] card=new int[N+1];
			
			
			
			Queue<Integer> queue=new LinkedList<>();
			if(N%2==0) {
				for(int i=4;i<N+1;i+=4) queue.add(i);
			}else {
				for(int i=2;i<N+1;i+=4) queue.add(i);
			}
			
			
			int flag=0;
			if(N%4==1||N%4==2) flag=1;
			
			while(queue.size()>1) {
				if (flag==1) {
					int tmp=queue.poll();
					queue.add(tmp);
				}
				else queue.poll();
				
				flag=(flag+1)%2;
			}
			sb.append(queue.poll());
		}

		System.out.println(sb.toString());

	}

}