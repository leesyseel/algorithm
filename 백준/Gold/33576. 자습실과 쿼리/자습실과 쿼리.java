import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());
        long[] area = new long[N + 1];
        
        for(int i = 0; i < M; i++){
            stk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(stk.nextToken());
            area[w] = Integer.parseInt(stk.nextToken());
        }
        for(int  i = 1; i < N + 1; i++){
            area[i] += area[i - 1];
        }
        
        int left = 0, right = N;
        int idx;
        long toOne, toN;
        for(int i = 0; i < Q; i++){
            idx = Integer.parseInt(br.readLine());
            if(idx < left || idx > right){
                sb.append("0\n");
                continue;
            }
            
            toOne = area[idx] - area[left];
            toN = area[right] - area[idx];
            
            if(toOne < toN || (toOne == toN && idx - 1 <= N - idx)){
                sb.append(toOne).append("\n");
                left = idx;
            }else if(toOne > toN || (toOne == toN && idx - 1 > N -idx)){
                sb.append(toN).append("\n");
                right = idx;
            }
        }
        System.out.println(sb);
    }
}