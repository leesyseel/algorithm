
import java.io.*;
import java.util.*;

public class Solution {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer stk;

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			stk = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(stk.nextToken());
			int E = Integer.parseInt(stk.nextToken());
			
			int[] edge = new int[V+1];
			ArrayList<Integer>[] node = new ArrayList[V+1];
			for(int i=1;i<=V;i++) {
				node[i]=new ArrayList<Integer>();
			}
			
			stk = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int from=Integer.parseInt(stk.nextToken());
				int to=Integer.parseInt(stk.nextToken());
				node[from].add(to);
				edge[to]++;
			}

			Queue<Integer> Q = new ArrayDeque<Integer>();
			
			for(int i=1;i<=V;i++) {
				if(edge[i]==0) {
					Q.add(i);
				}
			}
			
			while(!Q.isEmpty()) {
				int n = Q.poll();
				sb.append(n).append(" ");
				
				for(int j=0;j<node[n].size();j++) {
					int to = node[n].get(j);
					edge[to]--;
					if(edge[to]==0) {
						Q.add(to);
					}
				}
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}
}