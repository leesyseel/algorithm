import java.util.*;
import java.io.*;

class Main{
    
    static class Node implements Comparable<Node>{
        int day;
        int val;
        
        public Node(int day, int val){
            this.day = day;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.day != o.day){
                return this.day - o.day;
            }
            return -1 * (this.val - o.val);
        }
    }
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int N = Integer.parseInt(br.readLine());
		Node[] list = new Node[N];
		
		for(int i = 0; i < N; i++){
		    stk = new StringTokenizer(br.readLine());
		    int p = Integer.parseInt(stk.nextToken());
		    int d = Integer.parseInt(stk.nextToken());
		    
		    list[i] = new Node(d, p);
		}
		Arrays.sort(list);
		
		PriorityQueue<Integer> Q = new PriorityQueue<>();
		for(int i = 0; i < N; i++){
		    Q.add(list[i].val);
		    
		    if(list[i].day < Q.size()){
		        Q.poll();
		    }
		}
		
		int sum = 0;
		while(!Q.isEmpty()){
		    sum += Q.poll();
		}
        System.out.println(sum);
	}
}
