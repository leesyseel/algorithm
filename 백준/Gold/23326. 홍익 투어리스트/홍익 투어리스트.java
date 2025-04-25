import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int Q = Integer.parseInt(stk.nextToken());
        
        TreeSet<Integer> check = new TreeSet<>();
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            if(Integer.parseInt(stk.nextToken()) == 1){
                check.add(i);
            } 
        }
        
        int now = 1;
        for(int i = 0; i < Q; i++){
            stk = new StringTokenizer(br.readLine());
            int sign = Integer.parseInt(stk.nextToken());
            switch(sign){
                case 1:
                    int idx = Integer.parseInt(stk.nextToken());
                    if(check.contains(idx)){
                        check.remove(idx);
                    }else{
                        check.add(idx);
                    }
                    break;
                case 2:
                    int cnt = Integer.parseInt(stk.nextToken());
                    now = (now + cnt) % N;
                    if(now == 0) now = N;
                    break;
                case 3:
                    int res = -1;
                    Integer nxt = check.ceiling(now);
                    if(nxt == null){
                        if(!check.isEmpty()){
                            res = N - now + check.first();
                        } 
                    }else{
                        res = nxt - now;
                    }
                    sb.append(res).append("\n");
                    break;
            }
        }
        System.out.println(sb);   
    }
}