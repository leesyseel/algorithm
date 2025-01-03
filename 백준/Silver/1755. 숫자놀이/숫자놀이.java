import java.io.*;
import java.util.*;

public class Main{
	
	public static String solve(int n) {
		
		StringBuilder sbd = new StringBuilder();
		
		int tens = n / 10;
		int ones = n % 10;
		
		if(tens != 0) {
			sbd.append(numToString(tens)).append(" ");
		}
		
		return sbd.append(numToString(ones)).toString();
	}
	
	public static String numToString(int n) {
		switch (n) {
		case 0: return "zero";
		case 1: return "one";
		case 2: return "two";
		case 3: return "three";
		case 4: return "four";
		case 5: return "five";
		case 6: return "six";
		case 7: return "seven";
		case 8: return "eight";
		case 9: return "nine";
		default: return null;
		}
	}
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken());
        int N = Integer.parseInt(stk.nextToken());
        
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N -M + 1; i++) {
        	int num = i + M;
        	map.put(solve(num), num);

        }
        
        int cnt = 0;
        for(String key : map.keySet()) {
        	sb.append(map.get(key)).append(" ");
        	
        	if(++cnt == 10) {
        		sb.append("\n");
        		cnt = 0;
        	}
        }
        
        System.out.println(sb);
    }
}