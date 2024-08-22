import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
    static int result;
     
    static void make_plan(int idx, int sum, int[] price, int[] month) {
         
        if(sum>result) return;
         
        if(idx>=12) {
            if(result>sum) result=sum;
        }else {
            if(month[idx]!=0) {
                 
                //전부 1일권 사용
                make_plan(idx+1, sum+price[0]*month[idx], price, month);
                //한 달 권 사용
                make_plan(idx+1, sum+price[1], price, month);
                //3개월권 사용
                make_plan(idx+3, sum+price[2], price, month);
 
            }else {
                make_plan(idx+1, sum, price, month);
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
             
            int[] price=new int[4];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0;i <4; i++) {
                price[i] = Integer.parseInt(stk.nextToken());
            }
             
            int[] month=new int[12];
            stk = new StringTokenizer(br.readLine());
            for (int i = 0;i <12; i++) {
                month[i] = Integer.parseInt(stk.nextToken());
            }
             
            result=price[3];
            make_plan(0,0, price, month);
             
            sb.append(result).append("\n");
             
        }
        System.out.println(sb);
 
    }
 
}