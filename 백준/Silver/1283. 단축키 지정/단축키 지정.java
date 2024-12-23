import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[26];
        
        for(int i = 0; i < N ; i++){
            String[] str = br.readLine().split(" ");
            
            int str_idx = -1;
            int char_idx = -1;
            
            for(int j = 0; j < str.length; j++){
                char tmp = str[j].charAt(0);
                if(tmp >= 97 && !check[tmp - 97]){
                    check[tmp - 97] = true;
                    str_idx = j;
                    char_idx = 0;
                    break;
                }else if(tmp < 97 && !check[tmp - 65]){
                    check[tmp - 65] = true;
                    str_idx = j;
                    char_idx = 0;
                    break;
                }
            }
            
            if(str_idx < 0){
                for(int j = 0; j < str.length; j++){
                    for(int k = 1; k < str[j].length(); k++){
                        char tmp = str[j].charAt(k);
                        if(tmp >= 97 && !check[tmp - 97]){
                            check[tmp - 97] = true;
                            str_idx = j;
                            char_idx = k;
                            break;
                        }else if(tmp < 97 && !check[tmp - 65]){
                            check[tmp - 65] = true;
                            str_idx = j;
                            char_idx = k;
                            break;
                        }
                    }
                    if(str_idx >= 0) break;
                }
            }
            
            if( str_idx < 0){
                for(int j = 0; j < str.length; j++){
                    sb.append(str[j]).append(" ");
                }
            }else{
                for(int j = 0; j < str.length; j++){
                    if(j != str_idx){
                        sb.append(str[j]).append(" ");
                    }else{
                        for(int k = 0; k < str[j].length(); k++){
                            if(char_idx != k){
                                sb.append(str[j].charAt(k));
                            }else{
                                sb.append("[").append(str[j].charAt(k)).append("]");
                            }
                        }
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}