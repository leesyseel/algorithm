import java.util.*;
import java.io.*;

class Main{
    static int[] parent;
    
    static void make(int n){
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }
    
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
    
    static int find(int a){
        if(parent[a] == a) return a;
        
        return parent[a] = find(parent[a]);
    }  
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(stk.nextToken());
		int M  = Integer.parseInt(stk.nextToken());
		
		parent = new int[N + 1];
		make(N);
		
		for(int i = 0; i < M; i++){
		    stk = new StringTokenizer(br.readLine());
		    int sign = Integer.parseInt(stk.nextToken());
		    int a = Integer.parseInt(stk.nextToken());
		    int b = Integer.parseInt(stk.nextToken());
		    
		    if(sign == 0) union(a, b);
		    else{
		        String res = "NO\n";
		        if(find(a) == find(b)) res = "YES\n";
		        sb.append(res);
		    }
		}
		System.out.println(sb);
	}
}
