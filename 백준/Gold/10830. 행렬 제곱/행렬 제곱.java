import java.util.*;
import java.io.*;

class Main{
    static int N;
    static int MOD = 1000;
    
    static int[][] solve(int[][] arr, long B){
        if(B == 1L) return arr;
        
        int[][] res = solve(arr, B / 2);
        res = multiply(res, res);
        
        if(B % 2 == 1L){
            res = multiply(res, arr);
        }
        return res;
    }
    
    static int[][] multiply(int[][] arr1, int[][] arr2){
        int[][] res = new int[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    res[i][j] += arr1[i][k] * arr2[k][j];
                }
                res[i][j] %= MOD;
            }
        }
        return res;
    }
    
	public static void main (String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer stk;
	    
	    stk = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(stk.nextToken());
	    long B = Long.parseLong(stk.nextToken());
	    
	    int[][] arr = new int[N][N];
	    for(int i = 0; i < N; i++){
	        stk = new StringTokenizer(br.readLine());
	        for(int j = 0; j < N; j++){
	            arr[i][j] = Integer.parseInt(stk.nextToken()) % MOD;
	        }
	    }
	    
	    arr = solve(arr, B);
	    for(int i = 0; i < N; i++){
	        for(int j = 0; j < N; j++){
	            sb.append(arr[i][j] + " ");
	        }
	        sb.append("\n");
	    }
	    System.out.println(sb);

	}
}
