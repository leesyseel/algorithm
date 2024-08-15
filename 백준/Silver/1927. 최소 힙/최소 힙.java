import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class minHeap{
	private ArrayList<Integer> heap;
	
	public minHeap() {
		heap=new ArrayList<>();
		heap.add(0);
	}
	
	public void insert(int num) {
		heap.add(num);
		int pos=heap.size()-1;
		while(pos>1&&heap.get(pos/2)>heap.get(pos)) {
			int tmp=heap.get(pos/2);
			heap.set(pos/2, heap.get(pos));
			heap.set(pos, tmp);
            pos=pos/2;
		}
	}
	
	public int pop() {
		
		if(heap.size()==1) {
            return 0;
        }
		
		int minval=heap.get(1);
		int pos=heap.size()-1;
		heap.set(1, heap.get(pos));
		heap.remove(pos);
		pos=1;
		
		while(pos*2<=heap.size()-1) {
			
			int childPos=pos*2;
			int child=heap.get(childPos);
			
			if((childPos+1<=heap.size()-1)&&(child>heap.get(childPos+1))) {
				childPos+=1;
				child=heap.get(childPos);
			}
			
			if(heap.get(pos)<child) break;
			
			heap.set(childPos,heap.get(pos));
			heap.set(pos, child);
			pos=childPos;
		}
		return minval;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());
		minHeap heap=new minHeap();

		while (N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			
			
			if(input==0) {
				sb.append(heap.pop()+"\n");
			}else {
				heap.insert(input);
			}
			
		}
		System.out.println(sb);
	}

}