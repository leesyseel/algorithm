import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        
        Set<String> dict = new HashSet<>();
        for(int i = 0; i < N; i++){
            dict.add(br.readLine());
        }
        
        for(int j = 0; j < M; j++){
            int cnt = N;
            String[] article = br.readLine().split(",");
            for(String S : article){
                dict.remove(S);
            }
            sb.append(dict.size()).append("\n");
        }
        System.out.println(sb);
    }
}