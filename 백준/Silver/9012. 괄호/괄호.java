import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder stack = new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		String[] inp;
		boolean flag;
		for(int i=0;i<N;i++) {
			flag=true;
			inp=br.readLine().split("");
			
			for(int j=0;j<inp.length;j++) {
				if(inp[j].equals("(")) stack.append('(');
				else {
					int L=stack.length();
					if(L>0) {
						if(stack.charAt(L-1)=='(') stack.deleteCharAt(L-1);
						else {flag=false; break;}
					}else {flag=false; break;}
				}
			}
			if(stack.length()!=0) flag=false;
			
			if (flag) sb.append("YES\n");
			else sb.append("NO\n");
			stack.setLength(0);
		}
		System.out.println(sb);
		
	}
}