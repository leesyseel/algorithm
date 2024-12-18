import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int one = Integer.parseInt(br.readLine());
		int two = Integer.parseInt(br.readLine());

		int res = 0;
		int curl, tmp;
		for (int i = 0; i < 3; i++) {
			curl = two % 10;
			tmp = one * curl;
			sb.append(tmp).append("\n");
			res += tmp * Math.pow(10, i);
			two = two / 10;
		}
		sb.append(res);
		System.out.println(sb);
	}
}