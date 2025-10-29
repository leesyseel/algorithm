import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    Map<String, Integer> map = new HashMap<>();
		    
		    for(int i = 0; i < n; i++){
		        StringTokenizer stk = new StringTokenizer(br.readLine());
		        String name = stk.nextToken();
		        String type = stk.nextToken();
		        
		        map.put(type, map.getOrDefault(type, 0) + 1);
		    }
		    
		    int res = 1;
		    for(String key : map.keySet()){
		        res = res * (map.get(key) + 1);
		    }
		    sb.append((res - 1) + "\n");
		}
		System.out.println(sb);
	}
}
