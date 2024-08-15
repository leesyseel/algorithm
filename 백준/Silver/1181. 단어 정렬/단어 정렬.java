import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Set<String> set=new HashSet<String>();
		int N = Integer.parseInt(bf.readLine());
		for(int i=0;i<N;i++) {
			set.add(bf.readLine());
		}
		bf.close();
		
		ArrayList<String> list = new ArrayList<>(set);
		
		Collections.sort(list, new Comparator<String>(){
			public int compare(String s1, String s2) {
				if (s1.length()!=s2.length()) {
					return s1.length()-s2.length();
				}else{
					return s1.compareTo(s2);
				}
			}
		});
		
		for(String m : list) {
			bw.append(m).append("\n");
		}
		bw.flush();
		bw.close();
	}

}
