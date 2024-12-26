import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String origin = br.readLine();
        for(int i = 0; i < origin.length(); i++){
            char curl = origin.charAt(i);
            
            if(curl >= 97) curl -= 32;
            else curl += 32;
            sb.append(curl);
        }
        System.out.println(sb);
    }
}