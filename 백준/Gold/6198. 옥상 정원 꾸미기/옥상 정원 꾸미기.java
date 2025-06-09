import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        long res = 0;
        
        stack[0] = Integer.parseInt(br.readLine());
        int top = 1;
        
        for(int i = 1; i < N; i++){
            int h = Integer.parseInt(br.readLine());
            
            while(top > 0){
                if(stack[top - 1] <= h){
                    top--;
                }else{
                    break;
                }
            }
            res += top;
            stack[top++] = h;
        }
        System.out.println(res);
    }
}