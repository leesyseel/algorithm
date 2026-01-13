import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i = 0; i < N; i++){
		    int num = Integer.parseInt(br.readLine());
		    
		    if(i % 2 == 0) maxHeap.add(num);
		    else minHeap.add(num);
		    
		    if(maxHeap.size() != 0 && minHeap.size() != 0){
		        if(minHeap.peek() < maxHeap.peek()){
		            int tmp = maxHeap.poll();
		            maxHeap.add(minHeap.poll());
		            minHeap.add(tmp);
		        }
		    }
		    sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}
}
