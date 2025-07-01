import java.io.*;
import java.util.*;

public class Main{
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
    
    static int find(int n){
        if(parent[n] == n) return n;
        
        return parent[n] = find(parent[n]); 
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        
        parent = new int[N + 1];
        make(N);
        
        stk = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(stk.nextToken());
        int[] knew = new int[K];
        for(int i = 0; i < K; i++){
            knew[i] = Integer.parseInt(stk.nextToken());
        }
        
        int[] party = new int[M];
        for(int i = 0; i < M; i++){
            stk = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(stk.nextToken());
            int idx = Integer.parseInt(stk.nextToken());
            party[i] = idx;
            
            for(int j = 1; j < p; j++){
                int tmp = Integer.parseInt(stk.nextToken());
                union(idx, tmp);
            }
        }
        
        int res = 0;
        for(int i = 0; i < M; i++){
            boolean flag = true;
            for(int j = 0; j < K; j++){
                if(find(party[i]) == find(knew[j])){
                    flag = false;
                    break;
                }
            }
            if(flag) res++;
        }
        System.out.println(res);
    }
}