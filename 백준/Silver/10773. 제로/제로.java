import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] stack =new int[K];
        int top=0;
        
        int num;
        for(int i=0;i<K;i++){
            num=Integer.parseInt(br.readLine());
            if(num==0){
                top--;
            }else{
                stack[top++]=num;
            }
        }
        
        int res=0;
        int bot=0;
        while(bot!=top){
            res+=stack[bot++];
        }
        
        System.out.println(res);
    }
}