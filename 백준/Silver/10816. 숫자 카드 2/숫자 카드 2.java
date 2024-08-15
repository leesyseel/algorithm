import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String[] input;
		input = br.readLine().split(" ");

		Map<String, Integer> card = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (card.containsKey(input[i]))
				card.replace(input[i], card.get(input[i]) + 1);
			else
				card.put(input[i], 1);
		}

		int M = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");

		for (int i = 0; i < M; i++) {
			if (card.containsKey(input[i]))
				sb.append(card.get(input[i])).append(" ");
			else
				sb.append("0 ");
		}
		System.out.println(sb);
	}

}
