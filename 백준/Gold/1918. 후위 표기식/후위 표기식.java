import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String mid = br.readLine();
        char[] stack = new char[mid.length()];
        int top=0;

        for (int i = 0; i < mid.length(); i++) {
            char now = mid.charAt(i);
            
            if(now=='(') {
            	stack[top++]=now;
            }else if(now==')') {
            	while(top!=0&&stack[top-1]!='(') {
            		sb.append(stack[--top]);
            	}
            	--top;
            }else if(now=='*'||now=='/') {
            	while(top!=0&&(stack[top-1]!='('&&stack[top-1]!='+'&&stack[top-1]!='-')) {
            		sb.append(stack[--top]);
            	}
            	stack[top++]=now;
            	
            }else if(now=='+'||now=='-'){
            	while(top!=0&&stack[top-1]!='(') {
            		sb.append(stack[--top]);
            	}
            	stack[top++]=now;
            	
            }else {
            	sb.append(now);
            }
        }
        
        while(top!=0) {
        	sb.append(stack[--top]);
        }

        System.out.println(sb);
    }
}