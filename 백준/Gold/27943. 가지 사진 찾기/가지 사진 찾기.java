import java.util.*;
import java.io.*;

class Main{
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long tmp = N / 2 + 1;
		
		System.out.printf("? %d\n", tmp);
		System.out.flush();
		
		String gaji = br.readLine();
		
		long start = tmp, end = tmp;

		long left = 1, r = tmp;
		while(left <= r){
		    long mid = (left + r) / 2;
		    System.out.printf("? %d\n", mid);
		    System.out.flush();
		    String ins = br.readLine();
		    
		    if(gaji.equals(ins)){
		        r = mid - 1;
		    }else{
		        left = mid + 1;
		    }
		}
		start = left;
		
		long right = N, l = tmp;
		while(l <= right){
		    long mid = (l + right) / 2;
		    System.out.printf("? %d\n", mid);
		    System.out.flush();
		    String ins = br.readLine();
		    
		    if(gaji.equals(ins)){
		        l = mid + 1;
		    }else{
		        right = mid - 1;
		    }
		}
		end = right;

		System.out.printf("! %d %d\n", start, end);
		System.out.flush();
	}
}
