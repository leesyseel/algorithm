import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T= Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] p = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				br.readLine();
				boolean isD = false;
				for(int i=0;i<p.length;i++) {
					if(p[i].equals("D")) {
						isD=true;
						break;
					}
				}
				if(isD) sb.append("error\n");
				else sb.append("[]\n");
				continue;
			}
			
			String tmp = br.readLine();
			String[] s=tmp.substring(1, tmp.length()-1).split(",");
			int[] arr= new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(s[i]);
			}
			
			boolean flag=false;
			int front=0, back=n-1;
			for(int i=0;i<p.length;i++) {
				switch(p[i]) {
				case "R":
					flag=!flag;
					break;
				case "D":
					if(flag)
						back--;
					else
						front++;
				}
			}
			
			if(front<=back) {
				sb.append("[");
				if(flag) {
					for(int i=back;i>=front;i--) {
						sb.append(arr[i]);
						if(i!=front) sb.append(",");
					}
				}else {
					for(int i=front;i<=back;i++) {
						sb.append(arr[i]);
						if(i!=back) sb.append(",");
					}
				}
				sb.append("]\n");
			}else if(back+1==front) {
				sb.append("[]\n");
			}else {
				sb.append("error\n");
			}
			
		}		
		System.out.println(sb);
	}

}
