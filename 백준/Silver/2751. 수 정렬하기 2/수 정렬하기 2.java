import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Integer> List = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			List.add(Integer.parseInt(bf.readLine()));
		}
		bf.close();
		
		Collections.sort(List);
		
		for(int i=0;i<N;i++) {
			bw.append(List.get(i)+"").append("\n");
		}
		bw.flush();
		bw.close();
	}

}
