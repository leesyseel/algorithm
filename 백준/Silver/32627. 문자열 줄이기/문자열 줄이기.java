import java.util.*;
import java.io.*;

class Main{
    
    static class Alphabet{
        int idx;
        char alpha;
        boolean flag;
        
        public Alphabet(int idx, char alpha){
            this.idx = idx;
            this.alpha = alpha;
            this.flag = true;
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		Alphabet[] arr = new Alphabet[N];
		char[] origin = br.readLine().toCharArray();
		for(int i = 0; i < N; i++){
		    arr[i] = new Alphabet(i, origin[i]);
		}
		Arrays.sort(arr, (o1, o2) ->  o1.alpha - o2.alpha);
		
		for(int i = 0; i < M; i++){
		    arr[i].flag = false;
		}
		Arrays.sort(arr, (o1, o2) ->  o1.idx - o2.idx);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++){
		    if(arr[i].flag) sb.append(arr[i].alpha);
		}
        System.out.println(sb);
	}
}
