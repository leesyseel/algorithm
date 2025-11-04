import java.util.*;
import java.io.*;

class Main{
    
    static int M = 1000001;
    static int[] primes;
    
    static void makePrimes(){
        for(int i = 2; i < M; i++){
		    primes[i] = i;
		}
		for(int i = 2; i < M; i++){
		    if(primes[i] == 0) continue;
		    
		    for(int j = i + i; j < M; j += i){
		        primes[j] = 0;
		    }
		}
    }
    
    static int isPrime(int a, int b){
        
        int num = Integer.parseInt("" + a + b);
        
        if(primes[num] == 0){
            return 0;    
        }
        return 1;
    }
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		primes = new int[M];
		makePrimes();
		primes[11] = 0;
		
		int[][] dp = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++){
		    for(int j = 1; j <= N; j++){
		        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + isPrime(i, j);
		    }
		}
		
		System.out.println(dp[N][N]);
	}
}
