import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(stk.nextToken());
		int[] queue = new int[N];
		String act;
		int top=0, rear=0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			act=stk.nextToken();
			
			switch (act) {
			case "push":
				queue[top++]=Integer.parseInt(stk.nextToken());
				break;
			case "pop":
				if(top==rear) sb.append(-1+"\n");
				else sb.append(queue[rear++]+"\n"); 
				break;
			case "size":
				sb.append(top-rear+"\n");
				break;
			case "empty":
				if(top==rear) sb.append(1+"\n");
				else sb.append(0+"\n");
				break;
			case "front":
				if(top==rear) sb.append(-1+"\n");
				else sb.append(queue[rear]+"\n"); 
				break;
			case "back":
				if(top==rear) sb.append(-1+"\n");
				else sb.append(queue[top-1]+"\n"); 
				break;
			}
		}
		System.out.println(sb);

	}
}
