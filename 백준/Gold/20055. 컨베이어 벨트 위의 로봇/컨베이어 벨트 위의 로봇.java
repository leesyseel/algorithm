import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        
        stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int twice = 2 * N;
        
        int[] belt = new int[twice];
        boolean[] robot = new boolean[twice];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < twice; i++){
            belt[i] = Integer.parseInt(stk.nextToken());
        }
        
        int level = 0;
        int cnt = 0;
        int on = 0;
        int off = N - 1;
        while(cnt < K){
            //한 칸 회전 +  내리기
            level++;
            on = (on + twice - 1) % twice;
            off = (off + twice - 1) % twice;
            if(robot[off]){
                robot[off] = false;
            }
            //로봇 이동 + 내리기
            for(int i = 1; i < N ; i++){
            	int from = (off + twice - i) % twice;
            	int to = (from + 1) % twice;
                if(robot[from] && !robot[to] && belt[to] > 0){
                    robot[from] = false;
                    robot[to] = true;
                    if(--belt[to] == 0){
                        cnt++;
                        if(cnt == K) break;
                    }
                }
            }
            if(robot[off]){
                robot[off] = false;
            }
            //로봇 올리기
            if(belt[on] > 0){
                robot[on] = true;
                if(--belt[on] == 0){
                    cnt++;
                    if(cnt == K) break;
                }
            }
        }
        System.out.println(level);
    }
}