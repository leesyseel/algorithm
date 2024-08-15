import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	
	public static void main(String[] args) throws Exception{
		
		//입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(bf.readLine());
		String[] A=bf.readLine().split(" ");
		int M=Integer.parseInt(bf.readLine());
		String[] B=bf.readLine().split(" ");
		Map<String,Integer> map=new HashMap<>();
		for(String b : B) {
			map.put(b, 0);
		}
		
		//구현
		for(String a : A) {
			if (map.containsKey(a)) {
				map.replace(a, 1);
			}
		}
		for(String b : B) {
			System.out.println(map.get(b));
		}

	}

}
