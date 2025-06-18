import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        int N = Integer.parseInt(br.readLine());
        Integer[] limit = new Integer[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            limit[i] = Integer.parseInt(stk.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[M];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            boxes[i] = Integer.parseInt(stk.nextToken());
        }
        
        Arrays.sort(limit, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());
        
        if(limit[0] < boxes[0]){
            System.out.println("-1");
            return;
        }
        
        int[] loc = new int[N];
        boolean[] check = new boolean[M];
        
        int cnt = M;
        int time = 0;
        while(cnt > 0){
            time++;
            for(int i = 0; i < N; i++){
                if(cnt == 0) break;
                
                for(int j = loc[i]; j < M; j++){
                    if(check[j] || limit[i] < boxes[j]) {
                        loc[i]++;
                        continue;
                    }
                    
                    check[j] = true;
                    loc[i] = j + 1;
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(time);
    }
}