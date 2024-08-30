
import java.io.*;
import java.util.*;

public class Main {

	static boolean result;
	static List<Integer>[] friend;
	static boolean[] visit;

	static void DFS(int now, int L) {

		if (result)
			return;

		if (L == 5) {
			result = true;
		} else {
			
			visit[now]=true;
			for (int j = 0; j < friend[now].size(); j++) {
				int to = friend[now].get(j);
				if(!visit[to]) DFS(to,L+1);
			}
			visit[now]=false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		friend = new ArrayList[n];
		visit=new boolean[n];
		for (int i = 0; i < n; i++) {
			friend[i] = new ArrayList<Integer>();
		}

		while (m-- > 0) {

			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			friend[a].add(b);
			friend[b].add(a);

		}

		result = false;
		for (int i = 0; i < n; i++) {
			if (result) break;
			DFS(i,1);
		}
		if (result) System.out.println(1);
		else System.out.println(0);
	}
}
