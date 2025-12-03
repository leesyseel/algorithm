import java.util.*;
import java.io.*;

class Main{
    
    static int N;
    static int[] arr;
    
    static int solve(int lt, int rt){
        while(lt < rt){
            if(arr[lt] != arr[rt]) return 0;
            lt++; rt--;
        }
        return 1;
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
		    arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0){
		    stk = new StringTokenizer(br.readLine());
		    int S = Integer.parseInt(stk.nextToken()) - 1;
		    int E = Integer.parseInt(stk.nextToken()) - 1;
		    
		    sb.append(solve(S, E)+"\n");
		}
		System.out.println(sb);
	}
}
