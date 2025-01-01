import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String origin = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < origin.length(); i++){
            char curl = origin.charAt(i);
            
            stack.offerFirst(curl);
            
            if(curl == bomb.charAt(bombLen - 1) && stack.size() >= bombLen){
                boolean flag = true;
                
                
                Iterator<Character> iters = stack.iterator();
                for(int j = 1; j <= bombLen; j++){
                  if(bomb.charAt(bombLen - j) != iters.next()){
                    flag= false;
                    break;
                  }
                }
                
                if(flag){
                    for(int j = 0; j < bombLen; j++){
                        stack.pollFirst();
                    }
                }
            }
            
        }
        
        if(stack.isEmpty()){
            sb.append("FRULA");
        }else{
            int cnt = stack.size();
            while(cnt-- > 0){
                sb.append(stack.pollLast());
            }
        }
        System.out.println(sb);
    }
}