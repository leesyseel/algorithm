import java.util.*;
class Solution {
    
    static class Node{
        String name;
        int val;
        Node parent;
        
        public Node(String name, Node parent){
            this.name = name;
            this.val = 0;
            this.parent = parent;
        }
    }
    
    public void distribute(Node node, int cost){
        int ten = (int) (cost * 0.1);
        cost -= ten;
        node.val += cost;
        if(node.parent == null) return;
        distribute(node.parent, ten);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N  = enroll.length;
        int[] answer = new int[N];
        Map<String, Node> map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            String a = enroll[i];
            String b = referral[i];
            Node parent = null;
            
            if(!b.equals("-")){
                parent = map.get(b);
            }
            map.put(a, new Node(a, parent));
        }
        
        for(int i = 0; i < seller.length; i++){
            distribute(map.get(seller[i]), amount[i] * 100);
        }
        
        for(int i = 0; i < N; i++){
            answer[i] =  map.get(enroll[i]).val;
        }
        
        return answer;
    }
}