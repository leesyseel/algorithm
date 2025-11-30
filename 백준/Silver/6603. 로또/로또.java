import java.util.*;
import java.io.*;

class Main{
    
    static int k;
    static int[] arr, pick;
    static StringBuilder sb;
    
    static void DFS(int idx, int cnt){
        if(cnt == 6){
            for(int i = 0; i < 6; i++){
                sb.append(pick[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = idx; i < k; i++){
            pick[cnt] = arr[i];
            DFS(i + 1, cnt + 1);
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while(true){
		    StringTokenizer stk = new StringTokenizer(br.readLine());
		    k = Integer.parseInt(stk.nextToken());
		    if(k == 0) break;
		    
		    arr = new int[k];
		    pick = new int[6];
		    
		    for(int i = 0; i < k; i++){
		        arr[i] = Integer.parseInt(stk.nextToken());
		    }
		    
		    DFS(0, 0);
		    sb.append("\n");
		}
        System.out.println(sb);
	}
}
