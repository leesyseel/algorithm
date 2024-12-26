import java.io.*;
import java.util.*;

public class Main{
    
    static class Bus{
        int from;
        int to;
        int time;
        
        public Bus(int from, int to, int time){
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        
        Bus[] routes = new Bus[M];
        for(int i = 0; i < M; i++){
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int time = Integer.parseInt(stk.nextToken());
            routes[i] = new Bus(from, to, time);
        }
        
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        
        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                Bus B = routes[j];
                
                if(dist[B.from] != Long.MAX_VALUE && dist[B.to] > dist[B.from] + B.time)
                    dist[B.to] = dist[B.from] + B.time;
            }
        }
        
        boolean flag = false;
        for(int i = 0; i < M; i++){
            if(dist[routes[i].from] != Long.MAX_VALUE && dist[routes[i].to] > dist[routes[i].from] + routes[i].time){
                flag = true;
                break;
            }
        }
        
        if(flag){
            sb.append(-1);
        }else{
            for(int i = 2; i <= N; i++){
                long tmp = dist[i] != Long.MAX_VALUE ? dist[i] : -1;
                sb.append(tmp).append("\n");
            }
        }
        System.out.println(sb);
    }
}