import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Integer[] values = new Integer[N];
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            values[i] = Integer.parseInt(stk.nextToken());
        }
        
        int lt = 0;
        int rt = N - 1;
        Integer[] res = new Integer[2];
        Integer gap = Integer.MAX_VALUE;
        while(lt < rt){
            Integer val = values[lt] + values[rt];
            if(gap > Math.abs(val)){
                gap = Math.abs(val);
                res[0] = values[lt];
                res[1] = values[rt];
                
                if(gap == 0) break;
            }
            
            if(val < 0) lt++;
            else rt--;
        }
        
        System.out.println(res[0] + " " + res[1]);
    }
}