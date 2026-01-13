import java.util.*;
import java.io.*;

class Main{
    
    static class Seg{
        String str;
        Seg next;
        
        public Seg(String str){
            this.str = str;
            this.next = null;
        }
    }
    
    static class Node{
        Node left, right;
        Seg head, tail;
        
        public Node(String str, Node left){
            this.left = left;
            this.right = null;
            this.head = this.tail = new Seg(str);
        }
    }
    
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N + 1];
		
		Node before = new Node("start", null);
		arr[0] = before;
		
		for(int i = 1; i <= N; i++){
		    String name = br.readLine();
		    Node curl = new Node(name, before);
		    arr[i] = curl;
		    before.right = curl;
		    before = curl;
		}
		
		for(int i = 1; i < N; i++){
		    StringTokenizer stk = new StringTokenizer(br.readLine());
		    
		    Node front = arr[Integer.parseInt(stk.nextToken())];
		    Node back = arr[Integer.parseInt(stk.nextToken())];
		    
		    front.tail.next = back.head;
		    front.tail = back.tail;
		    
		    back.left.right = back.right;
		    if(back.right != null){
		        back.right.left = back.left;
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(Seg S = arr[0].right.head; S != null; S = S.next){
		    sb.append(S.str);
		}
		System.out.println(sb);
	}
}
