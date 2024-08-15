import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuffer sb = new StringBuffer();

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];

		for (int i = 1; i < N+1 ; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(stk.nextToken());
		}


		while (M-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(stk.nextToken());
			int right = Integer.parseInt(stk.nextToken());

			sb.append((arr[right] -arr[left-1] )+ "\n");
		}

		System.out.println(sb);
	}

}