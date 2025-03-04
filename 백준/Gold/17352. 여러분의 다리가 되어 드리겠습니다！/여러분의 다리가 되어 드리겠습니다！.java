import java.io.*;
import java.util.*;

class Main{
    static int[] parent;
    
    public static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA == parentB) return;
        
        if(parentA < parentB){
            parent[parentA] += parent[parentB];
            parent[parentB] = parentA;
        }else{
            parent[parentB] += parent[parentA];
            parent[parentA] = parentB;
        }
    }
    
    public static int find(int a){
        if(parent[a] < 0) return a;
        return find(parent[a]);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < N - 2; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            union(a,b);
        }
        
        int first = 0;
        int second = 0;
        for(int i = 1; i <= N; i++){
            if(parent[i] < 0){
                if(first == 0){
                    first = i;
                }else{
                    second = i;
                    break;
                }
            }
        }
        System.out.println(first+" "+second);
    }
}