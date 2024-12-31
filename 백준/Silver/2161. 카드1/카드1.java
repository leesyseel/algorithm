import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new ArrayDeque<>();
        for(int i = 1; i <= N ; i++){
            Q.add(i);
        }
        
        int tmp;
        while(Q.size() > 1){
            sb.append(Q.poll()).append(" ");
            tmp = Q.poll();
            Q.add(tmp);
        }
        sb.append(Q.poll()).append(" ");
        
        System.out.println(sb);
    }
}