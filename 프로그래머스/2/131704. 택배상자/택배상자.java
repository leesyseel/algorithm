import java.util.*;

class Solution {
    public int solution(int[] order) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int box = 1;
        int idx = 0;
        int n = order.length;
        
        while (box <= n) {
            if (box == order[idx]) {
                box++;
                idx++;
            } 
            else {
                stack.add(box);
                box++;
            }
            
            while (!stack.isEmpty() && idx < n && stack.peekLast() == order[idx]) {
                stack.pollLast();
                idx++;
            }
        }
        
        return idx;
    }
}