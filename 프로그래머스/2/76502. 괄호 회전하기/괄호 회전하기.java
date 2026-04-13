import java.util.*;
class Solution {
    
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++){
            char[] tmp = new char[arr.length];
            for(int j = i; j < arr.length; j++){
                tmp[j - i] = arr[j];
            }
            for(int j = 0; j < i; j++){
                tmp[arr.length - i + j] = arr[j];
            }
            
            if(solve(tmp)) answer++;
        }
        
        return answer;
    }
    
    public boolean solve(char[] arr){
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c : arr){
            if(c == '(' || c == '[' || c == '{'){
                stack.add(c);
            }else{
                if (stack.isEmpty()) return false;
                
                char top = stack.peekLast();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')){
                    stack.pollLast();
                }else{
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()) return false;
        
        return true;
    }
}

