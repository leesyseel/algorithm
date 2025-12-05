import java.util.*;
import java.io.*;

class Main{
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1){
		    System.out.println(0);
		    return;
		}
		
		int res = 0;
		boolean[] isNotPrime = new boolean[N + 1];
		int cnt = 0;
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i = 2; i <= N; i++){
		    if(isNotPrime[i]) continue;
		    
		    cnt++;
		    for(int j = i * 2; j <= N; j += i){
		        isNotPrime[j] = true;
		    }
		}
		
		int[] arr = new int[cnt];
		arr[0] = 2;
		int idx = 1;
		
		for(int i = 3; i <= N; i++){
		    if(isNotPrime[i]) continue;
            arr[idx] = i + arr[idx - 1];
		    if(++idx == cnt) break;
		}
		
		int lt = -1;
		int rt = 0;
		
		while(lt < rt && rt < cnt){
		    int a = lt < 0 ? 0 : arr[lt];
		    int b = arr[rt];
		    
		    if(b - a == N){
		        res++;
		        lt++; rt++;
		    }else if(b - a > N){
		        lt++;
		    }else{
		        rt++;
		    }
		}
		System.out.println(res);
	}
}
