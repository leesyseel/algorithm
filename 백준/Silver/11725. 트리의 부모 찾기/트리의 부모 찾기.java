import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int N = Integer.parseInt(br.readLine());

		int[] parent = new int[N + 1];
		Arrays.fill(parent, -1);
		parent[1] = 0;
		
		ArrayList<ArrayList<Integer>> link=new ArrayList<>();
		for(int i=0;i<=N;i++) {
			link.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(stk.nextToken());
			int num2 = Integer.parseInt(stk.nextToken());

			link.get(num1).add(num2);
			link.get(num2).add(num1);
		}

		Queue<Integer> Q= new ArrayDeque<>();
		Q.add(1);
		while(!Q.isEmpty()) {
			int num=Q.poll();
			
			for(int i=0;i<link.get(num).size();i++) {
				int child=link.get(num).get(i);
				if(parent[child]==-1) {
					parent[child]=num;
					Q.add(child);
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}

		System.out.println(sb);
	}

}