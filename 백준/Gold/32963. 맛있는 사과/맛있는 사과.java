import java.util.*;
import java.io.*;

class Main{
    
    static class Apple{
        int t;
        int s;
        
        public Apple(int t, int s){
            this.t = t;
            this.s = s;
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int Q = Integer.parseInt(stk.nextToken());
		Apple[] arr = new Apple[N];
		
		stk = new StringTokenizer(br.readLine());
		StringTokenizer stk2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
		    arr[i] = new Apple(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk2.nextToken()));
		}
		Arrays.sort(arr, (o1, o2) -> o1.t - o2.t);
		
		int max = 0;
		int cnt = 0;
        int[] count = new int[N];
        for(int i = N - 1; i >= 0; i--){
            if(max < arr[i].s){
                max = arr[i].s;
                cnt = 1;
            }else if(max == arr[i].s){
                cnt++;
            }
            count[i] = cnt;
        }
		
		while(Q-- > 0){
		    int p = Integer.parseInt(br.readLine());
		    int left = 0;
		    int right = N -1;
		    
		    while(left <= right){
		        int mid = (left + right) / 2;
		        
		        if(arr[mid].t >= p){
		            right = mid - 1;
		        }else{
		            left = mid + 1;
		        }
		    }
		    int res = 0;
		    if(left < N) res = count[left];
		    sb.append(res + "\n");
		}
        System.out.println(sb);
	}
}