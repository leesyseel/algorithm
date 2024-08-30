
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[] edge = new int[N+1];
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		

		for(int i=0;i<M;i++) {
			stk = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			edge[B]++;
			arr[A].add(B);
		}
		
		Queue<Integer> Q = new ArrayDeque<Integer>();
		
		for(int i=1;i<=N;i++) {
			if(edge[i]==0) {
				Q.add(i);
			}
		}
		
		while(!Q.isEmpty()) {
			int person = Q.poll();
			sb.append(person).append(" ");
			
			for(int j=0;j<arr[person].size();j++) {
				int tmp = arr[person].get(j);
				edge[tmp]--;
				if(edge[tmp]==0) {
					Q.add(tmp);
				}
			}
		}
		
		System.out.println(sb);
	}
}
