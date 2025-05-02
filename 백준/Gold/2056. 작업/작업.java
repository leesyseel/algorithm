import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] times = new int[N + 1];
        int[] start = new int[N + 1];
        int[] check = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        Queue<Integer> Q = new ArrayDeque<>();
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
            stk = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(stk.nextToken());
            int before = Integer.parseInt(stk.nextToken());
            
            if(before == 0){
                Q.add(i);
                continue;
            }
            
            check[i] = before;
            for(int j = 0;  j < before; j++){
                int b = Integer.parseInt(stk.nextToken());
                list[b].add(i);
            }
        }
        
        int res = 0;
        while(!Q.isEmpty()){
            int curl = Q.poll();
            int end = start[curl] + times[curl];
            res = res > end ? res : end;
            
            for(int nxt : list[curl]){
                start[nxt] = start[nxt] > end ? start[nxt] : end;
                if(--check[nxt] == 0){
                    Q.add(nxt);
                }
            }
        }
        System.out.println(res);
    }
}