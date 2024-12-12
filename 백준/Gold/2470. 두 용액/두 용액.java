import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long[] liquid = new long[n];
        for(int i=0;i<n;i++){
          liquid[i]=Long.parseLong(stk.nextToken());
        }
        Arrays.sort(liquid);
        
        int lt=0; int rt=n-1;
        long res=Long.MAX_VALUE;
        long resLT=0; long resRT=n-1;
        while(lt<rt){
            long sumLiquid = liquid[lt]+liquid[rt];
            
            if(Math.abs(0-res)>Math.abs(0-sumLiquid)){
                res=sumLiquid;
                resLT=liquid[lt];
                resRT=liquid[rt];
            }
            
            if(sumLiquid<=0) lt++;
            else rt--;
        }
        
        sb.append(resLT).append(" ").append(resRT);
        System.out.println(sb);
    }
}