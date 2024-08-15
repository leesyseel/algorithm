import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());

		int[] input = new int[N];
		int[] sortArr = new int[N];
		Map<Integer,Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(stk.nextToken());
			input[i] = num;
			sortArr[i]=num;

		}

		Arrays.sort(sortArr);
		
		map.put(sortArr[0], 0);
		int idx=1;

		for (int i = 1; i < N; i++) {
			int num=sortArr[i];
			if(!map.containsKey(num)) {
				map.put(num, idx++);
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(map.get(input[i])+" ");
		}

		System.out.println(sb);
	}

}
