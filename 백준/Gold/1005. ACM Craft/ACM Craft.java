import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());
            
            List<Integer>[] arr = new ArrayList[N+1];
            int[] times = new int[N + 1];
            int[] before = new int[N + 1];
            int[] sumTimes = new int[N + 1];
            
            stk = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                arr[i] = new ArrayList<>();
                times[i] = Integer.parseInt(stk.nextToken());
            }
            
            while(K-- > 0){
                stk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                
                arr[a].add(b);
                before[b]++;
            }
            
            int W = Integer.parseInt(br.readLine());
            
            Queue<Integer> Q = new ArrayDeque<>();
            for(int i = 1; i <= N; i++){
                if(before[i] != 0) continue;
                Q.add(i);
            }
            
            int len = Q.size(); 
            int[] longerTime = new int[N + 1];
            boolean[] check = new boolean[N + 1];
            
            while(!Q.isEmpty()){
                int curl = Q.poll();
                check[curl] = true;
                
                sumTimes[curl] += times[curl];
                if(curl == W) break;
                
                for(int next : arr[curl]){
                    before[next]--;
                    longerTime[next] = longerTime[next] > sumTimes[curl] ? longerTime[next] : sumTimes[curl];
                }
                
                if(--len == 0) {
                	for(int i = 1; i <= N; i++) {
                		if(check[i] || before[i] != 0) continue;
                		
                		sumTimes[i] += longerTime[i];
                		longerTime[i] = 0;
                		Q.add(i);
                	}
                	len = Q.size();
                }
            }
            sb.append(sumTimes[W]).append("\n");
        }
        System.out.println(sb);
    }
}