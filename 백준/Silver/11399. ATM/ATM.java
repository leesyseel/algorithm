import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] people = new int[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(input[i]);
		}

		int sum = 0;
		Arrays.sort(people);
		for (int i = 0; i < N; i++) {
			sum += people[i] * (N - i);
		}

		System.out.println(sum);
	}
}