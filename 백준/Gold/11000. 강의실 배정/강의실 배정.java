import java.util.*;
import java.io.*;

class Main{
    static class Lecture{
        int s;
        int t;
        
        public Lecture(int s, int t){
            this.s = s;
            this.t = t;
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Lecture[] arr = new Lecture[N];
		for(int i = 0; i < N; i++){
		    StringTokenizer stk = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(stk.nextToken());
		    int t = Integer.parseInt(stk.nextToken());
		    arr[i] = new Lecture(s, t);
		}
		Arrays.sort(arr, (o1, o2) -> o1.s - o2.s);
		
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		Q.add(arr[0].t);
		for(int i = 1; i < arr.length; i++){
		    Lecture nxt = arr[i];
		    
		    if(Q.peek() <= nxt.s){
		        Q.poll();
		    }
		    Q.add(nxt.t);
		}
		
        System.out.println(Q.size());
	}
}
